package stepdefs;

import client.StudentRestAssuredClient;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StudentStepdef {

    StudentRestAssuredClient restClient;
    public StudentStepdef(){
        restClient = StudentRestAssuredClient.getStudentRestAssuredClientInstance();
    }
    @Given("^user make an API Get request to retrieve student \"(.*)\"$")
    public void get(String studentNumber){
        restClient.getStudent(studentNumber);
    }
    @Then("^the response code is \"(.*)\"$")
    public void checkStatusCode(int responseCode){
            assertThat("Response code did not match",restClient.getResponse().getStatusCode(),is(responseCode));
        System.out.println(restClient.getResponse().getTime());
    }
}
