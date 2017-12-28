package stepdefs;

import client.StudentRestAssuredClient;
import cucumber.api.java.en.Given;


public class StudentWithCourse {

    StudentRestAssuredClient restClient;
    public StudentWithCourse(){
        restClient = StudentRestAssuredClient.getStudentRestAssuredClientInstance();
    }

    @Given("^I make an API Get request to retrieve student \"(.*)\" and enter parameters as \"(.*)\" and \"(.*)\" with limit value \"(.*)\"$")
    public void getStudentWithProgramme(String studentNumber , String programme, String programmeValue,String limitValue){
        System.out.println("==========StudentWithCourse============");
        restClient.getStudentWithCourse(studentNumber,programme,programmeValue,limitValue);
        restClient.getResponse().body().prettyPeek();
    }
}
