package client;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import java.util.logging.Logger;
import static com.jayway.restassured.RestAssured.given;

public class StudentGetRequest  {
    private final Logger log = Logger.getLogger(getClass().getName());

    StudentRestAssuredClient restClient;
    public StudentGetRequest(){
        restClient = StudentRestAssuredClient.getStudentRestAssuredClientInstance();
    }

//    @BeforeTest
    public void setUp(){
        RestAssured.baseURI="http://localhost";
        RestAssured.port=8080;
        RestAssured.basePath="/student";
    }

//    @Test
    public void getAllStudent(){

        Response response = given()
                .param("programme", "Financial Analysis")
                .param("limit",2)
                .log()
                .all()
                .when()
                .get("/list");
        System.out.println(response.body().prettyPeek());
        System.out.println(response.getStatusCode());
    }
}
