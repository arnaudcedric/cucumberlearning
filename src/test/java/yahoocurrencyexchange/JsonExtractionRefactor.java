package yahoocurrencyexchange;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/*
 *instead of duplicating param over and over add a hashmap since the param was a hashmap
 */
public class JsonExtractionRefactor {
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
    @Test
    public void test000(){
/*
Extracting count value from response
count is of type int
*/
        response = given()
                //setting all the parameters with param method
                .parameters(map)
                .log()
                .all()
                .when()
                //what is in the get is the resource
                .get("yql");

        response.body().prettyPeek();
        System.out.println("count value is : "+ response.then().extract().path("query.count"));
        assertThat(response.statusCode(),is(200));
        assertThat(response.statusCode(),equalTo(200));

    }


    @Test
    public void test00(){
/*
Extracting lang value from response
*/
        /*
        *
        * lang is of type String
        *
        *
        */

        response = given()
                //setting all the parameters with param method
                .param("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\",\"USDBRL\")")
                .param("format", "json")
                .param("env", "store://datatables.org/alltableswithkeys")
                .param("diagnostics", "true")
                .log()
                .all()
                .when()
                //what is in the get is the resource
                .get("yql");

        response.body().prettyPeek();
        System.out.println("lang value is : "+ response.then().extract().path("query.lang"));
        assertThat(response.statusCode(),is(200));
        assertThat(response.statusCode(),equalTo(200));


    }

    @Test
    public void test01(){
        /*
        * Extract the first Name "GBP/XAF" from array from rate
        */
        response = given()
                //setting all the parameters with param method
                .param("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\",\"USDBRL\")")
                .param("format", "json")
                .param("env", "store://datatables.org/alltableswithkeys")
                .param("diagnostics", "true")
                .log()
                .all()
                .when()
                //what is in the get is the resource
                .get("yql");
//        response.body().prettyPeek();
        System.out.println("rate value is : "+ response.then().extract().path("query.results.rate[0]")); //this will return the first array in rate
        System.out.println("name in rate is : "+ response.then().extract().path("query.results.rate[0].Name")); //this will return the name in the first array in rate
        assertThat(response.statusCode(),is(200));
        assertThat(response.statusCode(),equalTo(200));


    }

    @Test
    public void test02(){
        /*
        * get all the rate from response
        */

        response = given()
                //setting all the parameters with param method
                .param("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\",\"USDBRL\")")
                .param("format", "json")
                .param("env", "store://datatables.org/alltableswithkeys")
                .param("diagnostics", "true")
                .log()
                .all()
                .when()
                //what is in the get is the resource
                .get("yql");

//        response.body().prettyPeek();
        System.out.println("rate value is : "+ response.then().extract().path("query.results.rate.Rate")); //return all the rate from responses



    }

    @Test
    public void test001(){

        response = given()
                //setting all the parameters with param method
                .param("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\",\"USDBRL\")")
                .param("format", "json")
                .param("env", "store://datatables.org/alltableswithkeys")
                .param("diagnostics", "true")
                .log()
                .all()
                .when()
                //what is in the get is the resource
                .get("yql");

        response.body().prettyPeek();
        System.out.println("Name : "+ response.then().extract().path("query.results.rate[0].Name"));
        assertThat(response.statusCode(),is(200));
        assertThat(response.statusCode(),equalTo(200));


    }
    @Test
    public void test002() {

        List<String> rate = given()
                //setting all the parameters with param method
                .param("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\")")
                .param("format", "json")
                .param("env", "store://datatables.org/alltableswithkeys")
                .param("diagnostics", "true")
                .when()
                //what is in the get is the resource
                .get("yql")
//                .prettyPeek()
                .then()
                //extract what you want here
                .extract()
                .path("query.results.rate"); // return all the values under rate

        System.out.println("size of rate is = : " + rate.size()); //return the size of the rate
        System.out.println("rate is = : " + rate.toString());

    }

    @Test
    public void test003() {

        Map<String, String> rate =      given()
                //setting all the parameters with param method
                .param("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\")")
                .param("format", "json")
                .param("env", "store://datatables.org/alltableswithkeys")
                .param("diagnostics", "true")
                .when()
                //what is in the get is the resource
                .get("yql")
                .prettyPeek()
                .then()
                //extract what you want here
                .extract()
                .path("query.results");

        System.out.println("rate is = : " + rate);

    }
    @Test
    public void test004() {

        List<String> names =      given()
                //setting all the parameters with param method
                .param("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\")")
                .param("format", "json")
                .param("env", "store://datatables.org/alltableswithkeys")
                .param("diagnostics", "true")
                .when()
                //what is in the get is the resource
                .get("yql")
//                .prettyPeek()
                .then()
                //extract what you want here
                .extract()
                .path("query.results.rate.Name");

        System.out.println("value of name are : " + names);
        for ( String name : names ) {
            boolean b = name.equalsIgnoreCase("GBP/BRL");
            if (b==true){
                System.out.println("Name is : " + name.toString());
            }
        }

    }

    @Test
    public void test005() {
// get all the values with name USD/BRL
        List<String> names =      given()
                //setting all the parameters with param method
                .param("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\")")
                .param("format", "json")
                .param("env", "store://datatables.org/alltableswithkeys")
                .param("diagnostics", "true")
                .when()
                //what is in the get is the resource
                .get("yql")
//                .prettyPeek()
                .then()
                //extract what you want here
                .extract()
                // this is a groovy method findAll{it.Name=='USD/BRL'} which return a collection ArrayList
                .path("query.results.rate.findAll{it.Name=='USD/BRL'}");

        System.out.println("value of names are : " + names);
    }
    @Test
    public void test006() {
        log.info("From rate find the name==USD/BRL and give the Date");
        List<String> names =      given()
                //setting all the parameters with param method
                .param("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\",\"USDBRL\")")
                .param("format", "json")
                .param("env", "store://datatables.org/alltableswithkeys")
                .param("diagnostics", "true")
                .when()
                //what is in the get is the resource
                .get("yql")
//                .prettyPeek()
                .then()
                //extract what you want here
                .extract()
                // this is a groovy method findAll{it.Name=='USD/BRL'} which return a collection ArrayList
                //I will get a list of all Rate objects with Name USD/BRL
                // if there are duplicates you will have duplicates results
                .path("query.results.rate.findAll{it.Name=='USD/BRL'}.Date");
        System.out.println("value of names are : " + names);

    }

    @Test
    public void test06() {
        log.info("Find the names which have Rate > 500");
        List<String> names =      given()
                //setting all the parameters with param method
                .param("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\",\"USDBRL\")")
                .param("format", "json")
                .param("env", "store://datatables.org/alltableswithkeys")
                .param("diagnostics", "true")
                .when()
                //what is in the get is the resource
                .get("yql")
//                .prettyPeek()
                .then()
                //extract what you want here
                .extract()
                // this is a groovy method findAll{it.Name=='USD/BRL'} which return a collection ArrayList
                //I will get a list of all Rate objects with Name USD/BRL
                // if there are duplicates you will have duplicates results
                .path("query.results.rate.findAll{it.Rate>'500'}.Name");
        System.out.println("value of names are : " + names);

    }

    @Test
    public void test007(){

        response = given()
                //setting all the parameters with param method
                .param("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\")")
                .param("format", "json")
                .param("env", "store://datatables.org/alltableswithkeys")
                .param("diagnostics", "true")
                .log()
                .all()
                .when()
                //what is in the get is the resource
                .get("yql");

        response.body().prettyPeek();
        System.out.println("all the names in the response : "+ response.then().extract().path("query.results.rate.Name"));
        assertThat(response.statusCode(),is(200));
        assertThat(response.statusCode(),equalTo(200));


    }
    @Test
    public void test008() {
        log.info("Get all the ids that Start with USDB");
        List<String> value = given()
                //setting all the parameters with param method
                .param("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\")")
                .param("format", "json")
                .param("env", "store://datatables.org/alltableswithkeys")
                .param("diagnostics", "true")
                .when()
                //what is in the get is the resource
                .get("yql")
//                .prettyPeek()
                .then()
                //extract what you want here
                .extract()
                // this is a groovy method findAll{it.Name=='USD/BRL'} which return a collection ArrayList
                .path("query.results.rate.findAll{it.id==~/USDB.*/}");
        System.out.println(value);
    }
    @Test
    public void test009() {
        log.info("Get all the ids that ends with SD");
        List<String> value = given()
                //setting all the parameters with param method
                .param("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\")")
                .param("format", "json")
                .param("env", "store://datatables.org/alltableswithkeys")
                .param("diagnostics", "true")
                .when()
                //what is in the get is the resource
                .get("yql")
//                .prettyPeek()
                .then()
                //extract what you want here
                .extract()
                // this is a groovy method findAll{it.Name=='USD/BRL'} which return a collection ArrayList
                .path("query.results.rate.findAll{it.id==~/.*SD/}");
        System.out.println(value);
    }

}
