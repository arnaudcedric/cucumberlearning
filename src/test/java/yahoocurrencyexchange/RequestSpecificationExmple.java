package yahoocurrencyexchange;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.logging.Logger;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class RequestSpecificationExmple {

    private final Logger log = Logger.getLogger(getClass().getName());
    private Response response;
    private static HashMap<String,String> map = new HashMap<>();
    private static RequestSpecBuilder builder;
    private static RequestSpecification rspec;


    @BeforeClass
    public static void setUp(){
//        RestAssured.baseURI="https://query.yahooapis.com";
//        RestAssured.basePath="/v1/public";
        builder = new RequestSpecBuilder();
        builder.setBaseUri("https://query.yahooapis.com");
        builder.setBasePath("/v1/public");
        builder.addParam("q","SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\",\"USDBRL\")");
        builder.addParam("format", "json");
        builder.addParam("env", "store://datatables.org/alltableswithkeys");
        builder.addParam("diagnostics", "true");
        rspec = builder.build();
    }

    // provide the root() after then()
    // adding builder and rspec
    @Test
    public void test001(){

        given()
                //setting all the parameters with param method
                .spec(rspec)
                .when()
                //what is in the get is the resource
                .get("yql")
                .then()
                .root("query")
                .body("count",lessThan(8))
                .body("count",greaterThan(6))
                .body("count", equalTo(7))
                .root("query.results.rate")
                .body("Name",hasItems("GBP/XAF","USD/XAF","USD/BRL"))
                .body("Name",hasItem("GBP/USD"))
                .body("id",hasItems("USDBRL","GBPBRL"))
                .body("id",hasItem("USDEUR"));

    }
}
