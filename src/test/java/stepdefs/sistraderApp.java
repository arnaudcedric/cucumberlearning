package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * Created by acedric on 14/07/2017.
 */
public class sistraderApp {

//    @Given("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
//    public void enterCredentials(List<Credentials> credentials){
//        for (Credentials credential : credentials){
//            System.out.println(credential.getPassword()+" "+credential.getPassword());
//        }
//    }

    @Given("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterCredentials(String username,String password) {
        System.out.println(username +" "+ password);
    }

    @And("^click on login button$")
    public void clickOnLoginButton() {
        System.out.println("Click on login button ");
    }



}
