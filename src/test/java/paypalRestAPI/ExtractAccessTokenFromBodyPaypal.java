package paypalRestAPI;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ExtractAccessTokenFromBodyPaypal {
    private final Logger log = Logger.getLogger(getClass().getName());
    private static RequestSpecBuilder builder;
    private static RequestSpecification rspec;

    private final static String CLIENTID="ATz55n98p1ev9cstg7tf2uZZaOiEfbhbIT2__aifStGoKl3GKENACd7yGVK6QzNXry2sPM3oiSQOhXFQ";
    private final static String CLIENTSECRET="EGDnZyNzSZyXnhZ5AJVRHva_F0KhtNwE5DTgZfcO3Cgv0EBn1wU6ns5JLw4slRUPuRkX0ZdKtqwukjhq";
    private String accessToken;

    @BeforeTest
    public static void setUp(){
        RestAssured.baseURI="https://api.sandbox.paypal.com";
        RestAssured.basePath="/v1/oauth2/token";

    }

    @Test
    public void getToken(){
        //to get the access_token for paypal on a post
        // extracting the access_token
        accessToken = given()
                .parameters("grant_type","client_credentials")
                .auth()
                .preemptive()
                .basic(CLIENTID,CLIENTSECRET)
                .when()
                .post()
                .then()
                .log()
                .all()
                .extract()
                .path("access_token");

        System.out.println(accessToken);





    }
}
