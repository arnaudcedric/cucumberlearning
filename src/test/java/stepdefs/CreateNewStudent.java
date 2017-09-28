package stepdefs;

import client.RestAssuredClient;
import com.google.gson.Gson;
import cucumber.api.java.en.*;
import studentApp.Type.CourseType;
import studentApp.pojo.StudentPOJO;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateNewStudent {

    RestAssuredClient restClient;
    Gson gson;
    List<String> courses;
    public CreateNewStudent(){
        restClient = RestAssuredClient.getRestAssuredClientInstance();
        gson = new Gson();
        courses = new ArrayList<>();
    }

    @Given("^user create new student with firstName as \"([^\"]*)\" LastName as \"([^\"]*)\" email as \"([^\"]*)\" programme as \"([^\"]*)\" with path \"([^\"]*)\"")
    public void iPostANewStudentWithTheseCourse(String firstName,String lastName,String email,String programme,String path,List<CourseType> courseTypes){
        System.out.println("==========CreateNewStudent============");

//        for (CourseType courseType : courseTypes){
//            courses.add(courseType.getCourse());
//        }
        for (int i = 0; i < courseTypes.size() ; i++) {
            courses.add(courseTypes.get(i).getCourse());
        }
        restClient.createNewStudent(firstName,lastName,email,programme,path,courses);
    }

    @Then("^the response message is \"(.*)\"$")
    public void checkMessage(String message){

            assertThat(restClient.getResponse().body().asString(),is(message));


    }
}
