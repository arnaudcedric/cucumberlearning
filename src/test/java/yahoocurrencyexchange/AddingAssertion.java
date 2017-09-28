package yahoocurrencyexchange;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class AddingAssertion {

    private final Logger log = Logger.getLogger(getClass().getName());
    private Response response;
    private static HashMap<String,String> map = new HashMap<>();
    @BeforeTest
    public static void setUp(){
        RestAssured.baseURI="https://query.yahooapis.com";
        RestAssured.basePath="/v1/public";
        map.put("q","SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\",\"USDBRL\")");
        map.put("format", "json");
        map.put("env", "store://datatables.org/alltableswithkeys");
        map.put("diagnostics", "true");
    }

    //asserting count values
    @Test
    public void test001(){
// you can assert like this
    int count = given()
                //setting all the parameters with param method
                .parameters(map)
                .log()
                .all()
                .when()
                //what is in the get is the resource
                .get("yql")
        .then()
        .extract()
        .path("query.count");
        System.out.println(count);
        assertThat(count,is(7));
//or like below
            given()
                //setting all the parameters with param method
                .parameters(map)
                .when()
                //what is in the get is the resource
                .get("yql")
                .then()
                .body("query.count", equalTo(7));
//or like below

        int count1 = given()
                //setting all the parameters with param method
                .parameters(map)
                .log()
                .all()
                .when()
                //what is in the get is the resource
                .get("yql")
                .then()
                .extract()
                .path("query.count");

        assertThat(count1,is(7));

    }
    //assert a single Name
    //check name == GDP/XAF
    @Test
    public void test002(){

        /*String yql = given()
                //setting all the parameters with param method
                .parameters(map)
                .when()
                //what is in the get is the resource
                .get("yql")
                .then()
                .extract()
                .path("query.results.rate[0].Name");
        System.out.println(yql);
        assertThat(yql,is("GBP/XAF"));*/

        /*List<String> yql = given()
                //setting all the parameters with param method
                .parameters(map)
                .when()
                //what is in the get is the resource
                .get("yql")
                .then()
                .extract()
                .path("query.results.rate.Name");

                assertThat(yql,hasItem("GBP/XAF"));
                assertThat(yql,hasSize(7));*/

         given()
                //setting all the parameters with param method
                .parameters(map)
                .when()
                //what is in the get is the resource
                .get("yql")
                .then()
                .body("query.results.rate.Name",hasItem("GBP/USD"));

    }
    //asserting multiple Names
    @Test
    public void test003(){

        List<String> yql = given()
                //setting all the parameters with param method
                .parameters(map)
                .when()
                //what is in the get is the resource
                .get("yql")
                .then()
                .extract()
                .path("query.results.rate.Name");

        assertThat(yql,hasItems("GBP/XAF","USD/XAF","USD/BRL"));
        assertThat(yql,hasSize(7));

        given()
                //setting all the parameters with param method
                .parameters(map)
                .when()
                //what is in the get is the resource
                .get("yql")
                .then()
                .body("query.results.rate.Name",hasItems("GBP/XAF","USD/XAF","USD/BRL"));

    }

    //assert using logical function
    @Test
    public void test004(){

        given()
                //setting all the parameters with param method
                .parameters(map)
                .when()
                //what is in the get is the resource
                .get("yql")
                .then()
                .body("query.count",greaterThan(6));

        given()
                //setting all the parameters with param method
                .parameters(map)
                .when()
                //what is in the get is the resource
                .get("yql")
                .then()
                .body("query.count",lessThan(8));

    }
    //add multiple assertion
    @Test
    public void test005(){
        given()
                //setting all the parameters with param method
                .parameters(map)
                .when()
                //what is in the get is the resource
                .get("yql")
                .then()
                .body("query.count",lessThan(8))
                .body("query.count",greaterThan(6))
                .body("query.results.rate.Name",hasItems("GBP/XAF","USD/XAF","USD/BRL"))
                .body("query.results.rate.Name",hasItem("GBP/USD"))
                .body("query.count", equalTo(7));
    }

    @Test
    public void test006(){

    int count=given()
                //setting all the parameters with param method
                .parameters(map)
                .log()
                .headers()
                .when()
                //what is in the get is the resource
                .get("yql")
                .then()
                .extract()
                .path("query.count");
            assertEquals(7,count);
    }

    public void test007(){}
    public void test008(){}
    public void test009(){}

}
