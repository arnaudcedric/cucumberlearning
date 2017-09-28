package paypalRestAPI;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import java.util.logging.Logger;
import static com.jayway.restassured.RestAssured.given;

public class BaseClassPaypal {

    private final Logger log = Logger.getLogger(getClass().getName());

    public static String accessToken;

    //PUT YOUR CLIENT ID & CLIENT SECRET  HERE
    private final static String CLIENTID="ATz55n98p1ev9cstg7tf2uZZaOiEfbhbIT2__aifStGoKl3GKENACd7yGVK6QzNXry2sPM3oiSQOhXFQ";
    private final static String CLIENTSECRET="EGDnZyNzSZyXnhZ5AJVRHva_F0KhtNwE5DTgZfcO3Cgv0EBn1wU6ns5JLw4slRUPuRkX0ZdKtqwukjhq";

    @BeforeTest
    public static void setUp(){

        RestAssured.baseURI="https://api.sandbox.paypal.com";
        RestAssured.basePath="/v1";

        //to get the access_token for paypal on a post
        // extracting the access_token
        accessToken = given()
                .parameters("grant_type","client_credentials")
                .auth()
                .preemptive()
                .basic(CLIENTID,CLIENTSECRET)
                .when()
                .post("/oauth2/token")
                .then()
                .extract()
                .path("access_token");

        System.out.println("the token acces is : "+accessToken);

    }
}
