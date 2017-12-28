package stepdefs.tradingSteps;

import client.TradingClient;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import cucumber.api.PendingException;
import jdk.internal.org.xml.sax.InputSource;
import org.hamcrest.CoreMatchers;
import org.json.JSONObject;
import org.json.XML;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import tradingservices.trading.EventPojo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GetEventStep {
    EventPojo eventPojo;
    TradingClient restClient;
    Gson gson;
    public GetEventStep(){
        restClient = TradingClient.getTradingClientInstance();
        gson = new Gson();
    }

    @Given("^user is authenticated And provides an \"([^\"]*)\"$")
    public void userIsAuthenticatedAndProvidesAn(String id)  {
/* "([^"]*)" */
        restClient.getEvent(id);

//        restClient.reset();
//        restClient.getResponse();
//        String s = restClient.getEvent(id).asString();
//        System.out.println("STRING : ===== "+s);
//        eventPojo = gson.fromJson(s, EventPojo.class);
//        System.out.println();
//        System.out.println("    "+ eventPojo.getId());

    }
    @Then("^Assert response Body (\\d+)$")
    public void assertResponseBody(int id)  {

        String s = restClient.getEvent("2521774").asString();
        eventPojo = gson.fromJson(s, EventPojo.class);
        assertThat("Event ID did not match ",eventPojo.getId(),is(id));
//        restClient.reset();

//        converting json to xml
//        JSONObject json = new JSONObject(s);
//        String s1 = XML.toString(json);
//
//        System.out.println(" XML : "+ s1);

    }

    @Then("^name a child (Arnaud|Cedric|Daryl|Carole|Guy|Jackson)$")
    public void nameAChildArnaud(String name)  {
        System.out.println("name : " +name);
    }

    @Given("^user wants to get event pricing with id \"([^\"]*)\"$")
    public void userWantsToGetEventPricingWithId(String eventId) {
        restClient.getEventPricing(eventId);
    }

    @Then("^the response code for trading is \"(.*)\"$")
    public void checkStatusCode(int responseCode){
        assertThat("status code did not match ",restClient.getResponse().getStatusCode(), /*CoreMatchers.*/is(responseCode));
        System.out.println(restClient.getResponse().getStatusCode());
    }
}
