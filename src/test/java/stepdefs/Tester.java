package stepdefs;

import cucumber.api.java.en.*;

import java.util.List;

public class Tester {

    @Given("^I am a \"([^\"]*)\" tester$")
    public void iAmATester(String Tester_Type, List<TestTypes> testTypes)  {
//        List<List<String>> raw = table.raw();
        System.out.println("@Given I am a "+Tester_Type + " Tester");
//        System.out.println(raw.get(1).get(0) +" "+ raw.get(1).get(1));
        for (TestTypes testType: testTypes){
            System.out.println(testType.getCountry()+" "+ testType.getIndustry());
        }
    }
    @Then("^I \"([^\"]*)\" it$")
    public void iIt(String workOutType) {
        System.out.println("@Then I " +workOutType+" it");
    }
    @When("^I go to work$")
    public void iGoToWork() {
        System.out.println("@When I go to work");
    }
    @But("^Then developer \"([^\"]*)\" me$")
    public void thenDeveloperMe(String arg0)  {
        System.out.println("@But Then developer " + arg0 + " me");
    }

    @And("^My boss \"([^\"]*)\" me$")
    public void myBossMe(String arg0) {
        System.out.println("@And My boss " + arg0 + " me");
    }

    class TestTypes{
        private String industry;
        private String country;

        public String getIndustry() {
            return industry;
        }

        public String getCountry() {
            return country;
        }
    }

}
