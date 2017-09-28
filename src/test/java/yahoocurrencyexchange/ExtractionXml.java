package yahoocurrencyexchange;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.internal.path.xml.NodeChildrenImpl;
import com.jayway.restassured.response.Response;
import org.apache.xpath.axes.HasPositionalPredChecker;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.registerParser;
import static com.jayway.restassured.path.xml.XmlPath.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class ExtractionXml {

    private Logger log = Logger.getLogger(getClass().getName());
    private static HashMap<String,String> map = new HashMap<>();

    @BeforeTest
    public static void setUp(){
        RestAssured.baseURI="https://query.yahooapis.com";
        RestAssured.basePath="/v1/public";
        map.put("q","SELECT * FROM yahoo.finance.xchange WHERE pair in (\"GBPXAF\",\"USDXAF\",\"USDEUR\",\"USDBRL\",\"GBPBRL\",\"GBPUSD\",\"USDBRL\")");
        map.put("format", "xml");
        map.put("env", "store://datatables.org/alltableswithkeys");
        map.put("diagnostics", "true");
    }

    //1)Extract count value from the response
    @Test
    public void test001() {

        String count = given()
                .parameters(map)
                .when()
                .get("/yql")
                .then()
                .extract()
                .path("query.@yahoo:count");
        System.out.println("count is equal to : "+count);
        assertThat(count,is("7"));

    }

    //2) Extract lang vaue from the response
    @Test
    public void test002(){
        String lang = given()
                .parameters(map)
                .when()
                .get("/yql")
                .then()
                .extract()
                .path("query.@yahoo:lang");
        System.out.println("lang is equal to : "+lang);
        assertThat(lang,equalTo("en-US"));
    }

    //3) Extract first name from the first rate
    @Test
    public void test003(){

        String Name = given()
                .parameters(map)
                .when()
                .get("/yql")
                .then()
                .extract()
                .path("query.results.rate[0].Name");
        System.out.println(Name);


    }

    //4) Get the values under rate
    @Test
    public void test004(){

        String xml = given()
                .parameters(map)
                .when()
                .get("/yql")
                .andReturn()
                .asString();
                        // below is imported from xml.path.With
        String valuesUnderRate = with(xml).get("query.results.rate").toString();
        System.out.println("Values under Rate :"+valuesUnderRate); //as a string
    }

    //5) Get the size of rate
    @Test
    public void test005(){

        NodeChildrenImpl rate = given()
                .parameters(map)
                .when()
                .get("/yql")
                .then()
                .extract()
                .path("query.results.rate");
        System.out.println("size of rate"+rate.size());

    }

    //6) get all the names from the response
    @Test
    public void test006(){

        String xml = given()
                .parameters(map)
                .when()
                .get("/yql")
                .andReturn()
                .asString();

        String name = with(xml).get("query.results.rate.findAll{it.Name}.Name").toString();

        System.out.println("Name are : "+name);

    }

    //7) get all of the Name==USD/BRL
    @Test
    public void test007(){

        String xml = given()
                .parameters(map)
                .when()
                .get("/yql")
                .andReturn()
                .asString();

        String rateValueWithNameEqualUSDBRL = with(xml).get("query.results.rate.findAll{it.Name=='USD/BRL'}").toString();

        System.out.println("Name are : "+rateValueWithNameEqualUSDBRL);
    }


    //9) Extracting the attribute element id="INR=x" and getting the Rate ..using **
    @Test
    public void test008(){

        String xml = given()
                .parameters(map)
                .when()
                .get("/yql")
                .andReturn()
                .asString();

        String values = with(xml).get("query.results.rate.findAll{it.@id=='USDBRL'}.Rate").toString();

        System.out.println("values is : "+values);

        String values1 = with(xml).get("**.findAll{it.@id=='USDBRL'}.Rate").toString();

        System.out.println("values using ** :" + values1);
    }


    @Override
    public String toString() {
        return "YahooCurrencyExchangeXml{}";
    }
}
