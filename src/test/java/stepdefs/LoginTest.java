package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.logging.Logger;

/**
 * Created by acedric on 12/06/2017.
 */
public class LoginTest {

    private final Logger log = Logger.getLogger(getClass().getName());
    @Given("^user go to \"([^\"]*)\" on \"([^\"]*)\"$")
    public void iGoToSistraderApp(String url , String browser){
//        log.info("URL : "+ url + "Browser : " + browser);
        System.out.println("@Given user go to "+url+" on " + browser);
    }
    @And("^I enter \"([^\"]*)\" as \"([^\"]*)\"$")
    public void enterUsername(String username,String password){
//        log.info("URL : "+ username + "Browser : " + password);

        System.out.println("@And user enter "+username +" as "+password);
    }
    @And("^I click on login \"([^\"]*)\"$")
    public void clickOnLoginButton(String LoginButton){
        System.out.println("@And user click on " + LoginButton);
    }
    @Then("^Login should be \"([^\"]*)\"$")
    public void loginShouldBE(String expectedResult){
        System.out.println(expectedResult);
    }
}
