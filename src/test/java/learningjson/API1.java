package learningjson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

/**
 * Created by acedric on 19/06/2017.
 */
public class API1 {
    ValidatableResponse validatableResponse;
    Response response;
//    StudentRestAssuredClient restClient;
    Gson gson = new Gson();
    //this is test 2
    Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
    Eventservices eventservices = new Eventservices();
//    @Test
    public void test_01(){

        try {Reader reader = new FileReader("C:\\Workspace\\learningcucumber\\src\\test\\java\\Eventservices.json");

                Eventservices eventservices = gson.fromJson(reader, Eventservices.class);
                String s = eventservices.toString();
                System.out.println(s);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

//    @Test
    public void test_02(){
        Eventservices eventservices = createdummyObject();
        String json = gson1.toJson(eventservices);
        System.out.println(json);
    }

    public static Eventservices createdummyObject(){
        Eventservices eventservices = new Eventservices();
        eventservices.setMeetingGroup("turf");
        eventservices.setMeetingCode("237");
        eventservices.setMeetingCode("456");
        List<String> runners = new ArrayList();
        runners.add("arnaud");
        runners.add("cedric");

        eventservices.setRunners(runners);

        return eventservices;
    }

//    @Test
    public void testSISApi(){
         response = when().
                get("http://qa.sistrader.sis.tv:8080/SISTrader/api/event/3135532");
        System.out.println(response.statusCode());
    }
//    @Test
    public void testSISApi_1(){
//        RestAssured.authentication = basic("username", "password");

        Response response = given().auth().basic("admin", "password").
                when().get("http://qa.sistrader.sis.tv:8080/SISTrader/api/event/3135532");
        System.out.println(response.getBody());


    }

//    @Test
    public void eventGetResquest(){
    ResponseBody body = given().auth().basic("admin", "password").
            when().get("http://qa.sistrader.sis.tv:8080/SISTrader/api/event/3135536/pricing");

        System.out.println(body.prettyPeek());

}
//    @Test
    public void test_4(){
        given().auth().basic("admin", "password").
                when().get("http://qa.sistrader.sis.tv:8080/SISTrader/api/event/3135536/pricing").then()
        .assertThat().statusCode(200);
    }
//    @Test
    public void test_5(){

        Response response = given().auth().basic("admin", "password").
                when().get("http://qa.sistrader.sis.tv:8080/SISTrader/api/event/3135536/pricing");

        JsonPath jsonPath = response.getBody().jsonPath();
        System.out.println(jsonPath.prettyPeek());
        Object eventId = jsonPath.get("eventId");
        System.out.println(" yy : "+eventId.equals(3135536));
        assertEquals(jsonPath.get("eventId"),3135536);
        assertEquals(jsonPath.get("priceType"),"T");

    }

//    @Test
    public void test_6(){
        Response response = given().auth().basic("admin", "password").
                when().get("http://qa.sistrader.sis.tv:8080/SISTrader/api/event/3136463/pricing");
        JsonPath jsonPath = response.getBody().jsonPath().prettyPeek();
//        String prettify = response.getBody().jsonPath().prettify();
        System.out.println(jsonPath.get("markets[0].selections[0].name"));
//        System.out.println(prettify);
    }

//    @Test
    public void test_07(){
        given().auth().basic("admin", "password").
                when().get("http://qa.sistrader.sis.tv:8080/SISTrader/api/event/3136463/pricing")
        .then().
        statusCode(200)
        .body("eventId",equalTo(3136463));
    }
}
