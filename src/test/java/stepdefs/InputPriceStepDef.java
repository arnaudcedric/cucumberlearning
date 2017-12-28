package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by acedric on 12/06/2017.
 */
public class InputPriceStepDef {

    @Given("^I navigate to login page$")
    public void iNavigateToLoginPage() {
        System.out.println("Test pass -- ");
    }

    @And("^I enter username as (cedric|arnaud|TALLA) and password as \"([^\"]*)\"$")
    public void iEnterUsernameAsAndPasswordAs(String admin, String password)  {
        System.out.println(admin +"---"+password);
    }

    @And("^Click on login button (\\d+)$")
    public void clickOnLoginButton() {
        System.out.println("Test pass ");
    }
    @And("^Click on login button (\\d+) yut$")
    public void clickOnLoginButtonYut(int number) {
        System.out.println("number : "+number);
    }
    @Then("^I should be on the user form page$")
    public void iShouldBeOnTheUserFormPage() {
        System.out.println("Test pass ");
    }



}
