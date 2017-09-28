package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.util.List;

/**
 * Created by acedric on 02/03/2017.
 */

public class Login  {

//    private BaseUtil baseUtil;
//    public Login(BaseUtil baseUtil) {
//        this.baseUtil = baseUtil;
//    }
    @Given("^I navigate to the login$")
    public void  I_navigate_to_the_login(){
        System.out.println();
        System.out.println();
        System.out.println("@Given I navigate to the login ");
        System.out.println();

//        baseUtil.driver.get("http://slqv-spd-trade1.sis.tv:3000/");
    }
    @And("^I enter the following credentials$")
    public void I_enter_username_as_admin_and_password_as_password(/*DataTable data*/List<Credentials> credentials) {
//        List<List<String>> d = data.raw();

//        System.out.println("@And "+ d.get(0).get(0)+" "+"@And "+d.get(0).get(1));
//        System.out.println("@And "+ d.get(1).get(0)+" "+"@And "+d.get(1).get(1));
//        System.out.println("@And "+ d.get(2).get(0)+" "+"@And "+d.get(2).get(1));


        for (Credentials credential : credentials){
            System.out.println();
            System.out.print("Credentials : " + credential.getUsername() +" "+ credential.getPassword());
            System.out.println();
        }

    }
    @And("^Press enter$")
    public void Press_enter()
    {
        System.out.println("@And "+"press enter ");
    }

    @Then("^i should be in on the dashboard$")
    public void i_should_be_in_on_the_dashboard() {
        System.out.println();
        System.out.println("@Then "+"i should be ");
        System.out.println();

    }

    public class Credentials{
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "Credentials{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

}
