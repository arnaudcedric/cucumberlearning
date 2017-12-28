package client;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import studentApp.pojo.StudentPOJO;
import tradingservices.trading.EventPojo;

import java.util.logging.Logger;

import static com.jayway.restassured.RestAssured.basic;
import static com.jayway.restassured.RestAssured.given;
public class TradingClient {
    private final Logger log = Logger.getLogger(getClass().getName());
    private Response response;
    private final String baseurl = "http://worker.test.docker.sis.tv:5101";
    private final String basePath = "/SISTrader/api/event/";
    private String username="admin";
    private String password="password";
    private EventPojo eventPojo;
    private RequestSpecBuilder builder;
    private RequestSpecification requestSpec;
    private static TradingClient tradingClient = null;
    public static TradingClient getTradingClientInstance() {
        if (tradingClient == null) {
            tradingClient = new TradingClient();
        }
        return tradingClient;
    }
    private TradingClient() {
        eventPojo = new EventPojo();
    }
    public RequestSpecification buildRequestSpec(){
        builder = new RequestSpecBuilder();
        builder.setBaseUri(baseurl);
        builder.setBasePath(basePath);
        builder.setAuthentication(basic(username,password));
        requestSpec = builder.build();
        return requestSpec;
    }
    public Response getEvent(String eventId) {
        log.info("GET request to url == " + baseurl + "" + basePath +""+eventId);
        response = given()/*.auth().preemptive().basic(username,password)*/
                .log()
                .all()
                .spec(buildRequestSpec())
                .when()
                .get(eventId);

        response.body().prettyPrint();

        return response;
    }

    public Response getEventPricing(String eventId) {
        log.info("GET request to url == " + baseurl + "" + basePath +""+eventId);
        response = given()/*.auth().preemptive().basic(username,password)*/
                .log()
                .all()
                .spec(buildRequestSpec())
                .when()
                .get(eventId+"/pricing");

        response.body().prettyPrint();

        return response;
    }

    public Response getResponse() {

        return response;
    }

    public void reset() {
        RestAssured.reset();
        response = null;
    }
}
