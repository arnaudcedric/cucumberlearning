package client;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import studentApp.pojo.StudentPOJO;
import java.util.List;
import java.util.logging.Logger;
import static com.jayway.restassured.RestAssured.given;
public class RestAssuredClient {
    private final Logger log = Logger.getLogger(getClass().getName());
    private Response response;
    private final String baseurl = "http://localhost:8085";
    private final String basePath = "";
    private StudentPOJO studentPOJO;
    private RequestSpecBuilder builder;
    private RequestSpecification requestSpec;
    private static RestAssuredClient restAssuredClientInstance = null;
    public static RestAssuredClient getRestAssuredClientInstance() {
        if (restAssuredClientInstance == null) {
            restAssuredClientInstance = new RestAssuredClient();
        }
        return restAssuredClientInstance;
    }
    private RestAssuredClient() {
        studentPOJO = new StudentPOJO();
    }


    public RequestSpecification buildRequestSpec(){
        builder = new RequestSpecBuilder();
        builder.setBaseUri(baseurl);
        builder.setBasePath(basePath);
        requestSpec = builder.build();
        return requestSpec;
    }

    public Response getStudent(String studentNumber) {
        log.info("GET request to url == " + baseurl + studentNumber);
        response = given()
                .log()
                .all()
                .spec(buildRequestSpec())
                .when()
                .get(studentNumber);
        response.body().prettyPrint();
        return response;
    }

    public Response getStudentWithCourse(String studentNumber, String programme, String programmeValue){
        log.info("GET request from student with programme : " + programme + " programme value : " + programmeValue +" And student number : "+ studentNumber);

         response = given()
                 .param(programme, programmeValue)
                 .param("limit",2)
                 .log()
                 .all()
                 .spec(buildRequestSpec())
                .when()
                .get(studentNumber);
        System.out.println(response.body().prettyPrint());
        return response;
    }

    public Response getStudentWithCourse(String studentNumber, String programme, String programmeValue,String limitValue){
        log.info("GET request from student with programme : " + programme + " programme value : " +programmeValue +" And student number : "+ studentNumber);
        log.info("GET request to url == " + baseurl + studentNumber);

        response = given()
                .param(programme, programmeValue)
                .param("limit",limitValue)
                .log()
                .all()
                .spec(buildRequestSpec())
                .when()
                .get(studentNumber);
        response.body().prettyPrint();
        return response;
    }

    public Response createNewStudent(String firstName,String lastName,String email,String programme,String path,List<String> courses){

//This is a POST Resquest
//        int number = 0;
//        String[] newCourses = new String[number];
//
//        for (int i=0;i<=newCourses.length;i++){
//            courses.add(newCourses[i]);
//        }
//        courses.add("C#");
//        courses.add("JAVA");
//        courses.add("C++");

        studentPOJO.setFirstName(firstName);
        studentPOJO.setLastName(lastName);
        studentPOJO.setEmail(email);
        studentPOJO.setProgramme(programme);
        studentPOJO.setCourses(courses);

         response = given().
                contentType(ContentType.JSON)
                .log()
                .all()
                .spec(buildRequestSpec())
                .when()
                .body(studentPOJO)
                .post(path);
        System.out.println("post status code :  "+response.getStatusCode());
        return response;
    }

    public Response getResponse()
    {
        return response;
    }
}