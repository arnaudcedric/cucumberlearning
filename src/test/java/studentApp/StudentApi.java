package studentApp;
import com.google.gson.Gson;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;
import studentApp.pojo.StudentPOJO;
import java.util.ArrayList;
import java.util.List;
import static com.jayway.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
//import static org.hamcrest.Matchers.greaterThanOrEqualTo;
/**
 * Created by acedric on 09/07/2017.
 */
public class StudentApi extends StudentBase {
private Response response;
private Gson gson;
//    @Test
    public void testStudent(){
//        getAllStudent("list");
//        getOneStudent("101");
//        getStudentFromAnyCourse("list","Financial Analysis");
//        getStudentFromAnyCourseWithLimits("list","Financial Analysis",2);
//        createNewStudent();
    }

    @Test
    public void getAllStudent(/*String allStudent*/){
//        int statusCode = 200;
//     response = given()
//                .log()
//                .headers()
//                .when()
//                .get("list");
//
//        response.body().prettyPeek();
//        assertThat(response.statusCode(),is(statusCode));
        gson = new Gson();
        response = given()
                .log()
                .headers()
                .when()
                .get("/list");
        String s = response.body().asString();
        System.out.println(s);
        //converting json body into java object
        //this help in assertion
        StudentPOJO[] gsonStudentPojo = gson.fromJson(s, StudentPOJO[].class);
        System.out.println(gsonStudentPojo.getClass());

        assertThat(gsonStudentPojo[0].getFirstName(),is("Vernon"));
        assertThat(gsonStudentPojo[0].getLastName(),is("Harper"));
        assertThat(gsonStudentPojo[0].getEmail(),is("egestas.rhoncus.Proin@massaQuisqueporttitor.org"));
        assertThat(gsonStudentPojo[0].getProgramme(),is("Financial Analysis"));
        assertThat(gsonStudentPojo[0].getCourses(),hasItems("Accounting","Statistics"));
        assertThat(gsonStudentPojo[0].getCourses(),contains("Accounting","Statistics"));
    }

    public void getOneStudent(String oneStudent){
        given()
                .when()
                .get(oneStudent)
                .body()
                .prettyPeek();
    }


    public void getStudentFromAnyCourseWithLimits(String allStudent,String CourseName,int limitNumber){
//        Response response = given()
//                .when()
//                .get("/"+allStudent+"?programme="+CourseName+"&limit="+limitNumber);
        given()
                .param("programme",CourseName)
                .param("limit",limitNumber)
                .when()
                .get("/"+allStudent)
                .body().prettyPeek();
    }


    public void getStudentFromAnyCourse(String allStudent,String CourseName){
//        Response response = given()
//                .when()
//                .get("/"+allStudent+"?programme="+CourseName);
                given()
                .param("programme",CourseName)
                .when()
                .get("/"+allStudent)
                .body().prettyPeek();
    }

//    @Test
    public void createNewStudent(){
//This is a POST Resquest
        StudentPOJO studentPOJO = new StudentPOJO();
        List<String> courses = new ArrayList<>();
        courses.add("C#");
        courses.add("JAVA");
        courses.add("C++");

        studentPOJO.setFirstName("Arnaud");
        studentPOJO.setLastName("Talla");
        studentPOJO.setEmail("c@gmail.com");
        studentPOJO.setProgramme("Testing Automation");
        studentPOJO.setCourses(courses);

        given().
                contentType(ContentType.JSON)
                .when()
                .body(studentPOJO)
                .post()
                .statusCode();

    }

//    @Test
public void updateStudent(ArrayList<String> courses, StudentPOJO studentPOJO) {
    //This is a PUT request
    courses.add("C#");
    courses.add("JAVA");
    courses.add("C++");
    courses.add("Selenium WebDriver");
    courses.add("Jmeter");

    studentPOJO.setFirstName("Arnaud Cedric");
    studentPOJO.setLastName("Talla Soup");
    studentPOJO.setEmail("XXXXXXXXX@gmail.com");
    studentPOJO.setProgramme("Testing Automation Cucumber");
    studentPOJO.setCourses(courses);

    given().
            contentType(ContentType.JSON)
            .when()
            .body(studentPOJO)
            .put("/101")
            .then()
            .statusCode(201);

}

//    @Test
    public void updateStudentAttribute(List<String> courses,StudentPOJO studentPOJO) {
        //This is a PaTch request
        courses.add("C#");
        courses.add("JAVA");
        courses.add("C++");
        courses.add("Selenium WebDriver");
        courses.add("Jmeter");

        studentPOJO.setFirstName("Arnaud Cedric");
        studentPOJO.setLastName("Talla Soup");
        studentPOJO.setEmail("PATCH@gmail.com");
        studentPOJO.setProgramme("Testing Automation Cucumber");
        studentPOJO.setCourses(courses);

                given().
                contentType(ContentType.JSON)
                .when()
                .body(studentPOJO)
                .patch("/115")
                .then()
                .statusCode(200);
    }

//    @Test
    public void test001(){

         given()
                .log()
                .headers()
                .when()
                .get("/1")
         .body()
         .prettyPeek();

    }

//    @Test
    public void test002(){

                given()
                .param("programme","Computer Science")
                .log()
                .params()
                .when()
                .get("/list");

    }

//    @Test
    public void test003(List<String> courses,StudentPOJO studentPOJO){
        courses.add("Financial Modeling");
        courses.add("JAVA");
        courses.add("C++");


        studentPOJO.setFirstName("Daryl");
        studentPOJO.setLastName("Frank");
        studentPOJO.setEmail("tony@gmail.com");
        studentPOJO.setProgramme("Finance");
        studentPOJO.setCourses(courses);

                given().
                contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .body(studentPOJO)
                .post()
                .then()
                .statusCode(200)
                ;
    }
//    @Test
    public void test004(){
        Gson gson = new Gson();
         given()
                 .when()
                 .log()
                 .all()
                 .param("programme", "Financial Analysis")
                 .param("limit",3)
                 .get("/list")
                 .body()
                 .prettyPeek();
//        StudentType studentType = gson.fromJson(response.toString(), StudentType.class);
//        System.out.println(studentType);

    }

    @Override
    public String toString() {
        return "StudentApi{" +
                "response=" + response +
                '}';
    }

}
