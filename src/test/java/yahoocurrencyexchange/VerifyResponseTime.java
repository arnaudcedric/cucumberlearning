package yahoocurrencyexchange;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
public class VerifyResponseTime {
    private final Logger log = Logger.getLogger(getClass().getName());
    private Response response;
    private static HashMap<String,Object> responseHeader = new HashMap<>();
    private static RequestSpecBuilder builder;
    private static RequestSpecification rspec;
    private static ResponseSpecBuilder responseSpecBuilder;
    private static ResponseSpecification responseSpecification;

    @BeforeClass
    public static void setUp(){
//        RestAssured.baseURI="https://query.yahooapis.com";
//        RestAssured.basePath="/v1/public";
        //adding resquest builder
        builder = new RequestSpecBuilder();
        builder.setBaseUri("https://query.yahooapis.com");
        builder.setBasePath("/v1/public");
        builder.addParam("q","SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\",\"USDBRL\")");
        builder.addParam("format", "json");
        builder.addParam("env", "store://datatables.org/alltableswithkeys");
        builder.addParam("diagnostics", "true");
        rspec = builder.build();
        //building response
        responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectResponseTime(lessThan(5L),TimeUnit.SECONDS);
        responseSpecBuilder.expectBody("query.count",equalTo(7));
        responseSpecBuilder.expectStatusCode(200);
        //adding header as a map
//        responseHeader.put("Content-Type","application/json");
//        responseHeader.put("server","ATS");
//        responseSpecBuilder.expectHeaders(responseHeader);
        responseSpecification = responseSpecBuilder.build();
    }
    // provide the root() after then()
    // adding builder and rspec
    @Test
    public void test001(){
    long responseTime = given()
                //setting all the parameters with param method
                .spec(rspec)
                .when()
                //what is in the get is the resource
                .get("yql")
                .time();

        System.out.println("The time taken is : "+responseTime+" ms");

        long responseTime1 = given()
                .spec(rspec)
                .when()
                //what is in the get is the resource
                .get("yql")
                .timeIn(TimeUnit.SECONDS);

        System.out.println("The time taken is : "+responseTime1+" seconds");

        // adding assertion based in time
        // if i expect the response to complete in less than 5 seconds for example
        // the do the below

             /*given()
                //setting all the parameters with param method
                .spec(rspec)
                .when()
                //what is in the get is the resource
                .get("yql")
                .then()
                .time(lessThan(2L), TimeUnit.SECONDS);*/
        //adding response Spec
        given()
                //setting all the parameters with param method
                .spec(rspec)
                .when()
                //what is in the get is the resource
                .get("yql")
                .then()
                .spec(responseSpecification);


    }

}
