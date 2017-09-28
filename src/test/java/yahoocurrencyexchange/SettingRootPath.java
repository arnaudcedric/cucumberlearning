package yahoocurrencyexchange;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.logging.Logger;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class SettingRootPath {


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

    // provide the root() after then()
    @Test
    public void test001(){

        given()
                //setting all the parameters with param method
                .parameters(map)
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

    @AfterSuite
    public void tearDown(){
        RestAssured.reset();
    }

}
