package stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by acedric on 08/03/2017.
 */
public class Hook  {
//    public BaseUtil baseUtil;
//
//    public Hook(BaseUtil baseUtil) {
//        this.baseUtil = baseUtil;
//    }

    @Before()
    public void initialisation(Scenario scenario){

        System.out.println("opening FireFox");
//        driver = new FirefoxDriver();
        System.out.println();
        System.out.println("getId "+scenario.getId());
//        System.out.println("getName "+scenario.getName());
//        System.out.println("getScourceTageNames "+scenario.getSourceTagNames().size());
//        System.out.println("getSourceTagNames "+scenario.getSourceTagNames().toArray());

    }
    @After
    public void tearDown(){
        System.out.println();
        System.out.println("closeing Firefox");
    }
}
