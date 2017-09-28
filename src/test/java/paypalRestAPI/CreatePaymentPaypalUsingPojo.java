package paypalRestAPI;

import static org.hamcrest.Matchers.*;

import com.google.gson.Gson;
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.Test;
import paypalRestAPI.paymentPojo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static com.jayway.restassured.RestAssured.given;

public class CreatePaymentPaypalUsingPojo extends BaseClassPaypal{
    private final Logger log = Logger.getLogger(getClass().getName());

//    private Redirect_urls redirect_urls;
//    private Amount amount;
//    private Details details;
//    private Shipping_address shipping_address;
//    private Items items1;
//    private Items items2;
//    private Item_List item_list;
//    private List<Items> Items;
//    private Payment_Options payment_options;
//    private Transactions transaction;
//    private List<Transactions> transactions;
//    private Payer payer;
//    private PostObjectPaypal postObj;


    @Test
    public void createPayment(){

//        redirect_urls = new Redirect_urls();
//        redirect_urls.setCancel_url("https://www.paypal.com/cancel");
//        redirect_urls.setReturn_url("https://www.paypal.com/return");
//
//        details = new Details();
//        details.setSubtotal("30.00");
//        details.setTax("0.07");
//        details.setShipping("0.03");
//        details.setHandling_fee("1.00");
//        details.setShipping_discount("-1.00");
//        details.setInsurance("0.01");
//
//        amount = new Amount();
//        amount.setTotal("30.11");
//        amount.setCurrency("USD");
//        amount.setDetails(details);
//
//        //setting shipping
//        shipping_address = new Shipping_address();
//        shipping_address.setRecipient_name("PAB");
//        shipping_address.setLine1("4thFloor");
//        shipping_address.setLine2("unit34");
//        shipping_address.setCity("San Jose");
//        shipping_address.setCountry_code("US");
//        shipping_address.setPostal_code("95131");
//        shipping_address.setPhone("011862212345678");
//        shipping_address.setState("CA");
//
//        items1 = new Items();
//        items1.setName("hat");
//        items1.setDescription("Brown color hat");
//        items1.setQuantity("5");
//        items1.setPrice("3");
//        items1.setTax("0.01");
//        items1.setSku("1");
//        items1.setCurrency("USD");
//
//        items2 = new Items();
//        items1.setName("handbag");
//        items1.setDescription("Black color hand bag");
//        items1.setQuantity("1");
//        items1.setPrice("15");
//        items1.setTax("0.02");
//        items1.setSku("product34");
//        items1.setCurrency("USD");
//
//        Items = new ArrayList<>();
//        Items.add(items1);
//        Items.add(items2);
//
//
//        item_list = new Item_List();
//        item_list.setItems(Items);
//        item_list.setShipping_address(shipping_address);
//
//        payment_options = new Payment_Options();
//
//        payment_options.setAllowed_payment_method("INSTANT_FUNDING_SOURCE");
//
//        transaction = new Transactions();
//        transaction.setAmount(amount);
//        transaction.setCustom("EBAY_EMS_90048630024435");
//        transaction.setDescription("This is the payment transaction description.");
//        transaction.setInvoice_number("48787589674");
//        transaction.setItem_list(item_list);
//        transaction.setPayment_options(payment_options);
//        transaction.setSoft_descriptor("ECHI5786786");
//
//        transactions = new ArrayList<>();
//        transactions.add(transaction);
//
//        //Set payer
//        payer = new Payer();
//        payer.setPayment_method("paypal");
//
//        postObj = new PostObjectPaypal();
//        postObj.setIntent("sale");
//        postObj.setNote_to_payer("Contact us");
//        postObj.setRedirect_urls(redirect_urls);
//        postObj.setPayer(payer);
//        postObj.setTransactions(transactions);

        Redirect_urls red_url = new Redirect_urls();
        red_url.setCancel_url("https://www.paypal.com/cancel");
        red_url.setReturn_url("https://www.paypal.com/return");

        Details details = new Details();
        details.setHandling_fee("1.00");
        details.setInsurance("0.01");
        details.setShipping("0.03");
        details.setShipping_discount("-1.00");
        details.setSubtotal("30.00");
        details.setTax("0.07");

        //Create Amount
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setDetails(details);
        amount.setTotal("30.11");

        //Set the shipping address
        Shipping_address shipping_address = new Shipping_address();
        shipping_address.setCity("San Jose");
        shipping_address.setCountry_code("US");
        shipping_address.setLine1("4th Floor");
        shipping_address.setLine2("Unit #34");
        shipping_address.setPhone("011862212345678");
        shipping_address.setPostal_code("95131");
        shipping_address.setRecipient_name("Brian Robinson");
        shipping_address.setState("CA");

        //Set Items
        Items item = new Items();
        item.setCurrency("USD");
        item.setDescription("Brown hat.");
        item.setName("hat");
        item.setPrice("3");
        item.setQuantity("5");
        item.setSku("1");
        item.setTax("0.01");

        Items item2= new Items();
        item2.setCurrency("USD");
        item2.setDescription("Black handbag.");
        item2.setName("handbag");
        item2.setPrice("15");
        item2.setQuantity("1");
        item2.setSku("product34");
        item2.setTax("0.02");

        List<Items> items= new ArrayList<>();
        items.add(item);
        items.add(item2);

        //Item List
        Item_List item_list = new Item_List();
        item_list.setShipping_address(shipping_address);
        item_list.setItems(items);

        //Set payment options
        Payment_Options payment_options = new Payment_Options();
        payment_options.setAllowed_payment_method("INSTANT_FUNDING_SOURCE");

        //Set Transactions
        Transactions transaction = new Transactions();
        transaction.setAmount(amount);
        transaction.setCustom("EBAY_EMS_90048630024435");
        transaction.setDescription("The payment transaction description.");
        transaction.setInvoice_number("48787589673");
        transaction.setItem_list(item_list);
        transaction.setPayment_options(payment_options);
        transaction.setSoft_descriptor("ECHI5786786");

        List<Transactions> transactions = new ArrayList<>();
        transactions.add(transaction);

        //Set payer
        Payer payer = new Payer();
        payer.setPayment_method("paypal");

        PostObjectPaypal postObj = new PostObjectPaypal();
        postObj.setIntent("sale");
        postObj.setNote_to_payer("Contact us for any questions on your order.");
        postObj.setRedirect_urls(red_url);
        postObj.setPayer(payer);
        postObj.setTransactions(transactions);

        Gson gson = new Gson();
        String s = gson.toJson(postObj);

        System.out.println(s);

        given()
                //setting the contenttype
                .contentType(ContentType.JSON)
                //providing the authentication token
                .auth()
                .oauth2(accessToken)
                .when()
                //need to provide object of
                .body(s)
                //payment end point /payments/payment
                .post("/payments/payment ")
                .then()
                .log()
                .all();

    }

}
