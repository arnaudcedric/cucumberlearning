package studentApp;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeTest;


/**
 * Created by acedric on 10/07/2017.
 */
public class StudentBase {

    @BeforeTest
    public void setUp(){
        RestAssured.baseURI="http://localhost";
        RestAssured.port=8085;
        RestAssured.basePath="/student";
    }

//    public void createNewStudent(){
//         courses.add("C#");
//         courses.add("JAVA");
//         courses.add("C++");
//         studentPOJO.setFirstName("Arnaud");
//         studentPOJO.setLastName("Talla");
//         studentPOJO.setEmail("c@gmail.com");
//         studentPOJO.setProgramme("Computer Science");
//         studentPOJO.setCourses(courses);
//
//        given().
//                contentType(ContentType.JSON)
//                .when()
//                .body(studentPOJO)
//                .post();
//
//    }
}
