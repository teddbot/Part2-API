package safeboda;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateBooking extends  BookerBase {
//    @Test
//    public void updateBookingByPutTest()
//    {
//        JSONObject passJSON = new JSONObject();
//        passJSON.put("username",  "admin");
//        passJSON.put( "password", "password123");
//
//        Response tokenResponse = RestAssured.given().contentType("application/json").body(passJSON.toString()).post(" https://restful-booker.herokuapp.com/auth");
//
//        tokenResponse.prettyPrint();
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("firstname", "Teddy");
//        jsonObject.put("lastname", "Nzioka");
//        jsonObject.put("totalprice", 123);
//        jsonObject.put("depositpaid", true);
//        jsonObject.put("additionalneeds", "Computer Desk");
//        JSONObject bookingDates = new JSONObject();
//        bookingDates.put("checkin", "2022-10-18");
//        bookingDates.put("checkout", "2022-10-20");
//        jsonObject.put("bookingdates", bookingDates);
//
//        Response responseCreate = createNewBooking(jsonObject);
//        responseCreate.prettyPrint();
//
//        int newID = responseCreate.jsonPath().getInt("bookingid");
//
//        JSONObject jsonObjectUpdate = new JSONObject();
//        jsonObjectUpdate.put("firstname", "Teddy");
//        jsonObjectUpdate.put("lastname", "Nzioka");
//        jsonObjectUpdate.put("totalprice", 234);
//        jsonObjectUpdate.put("depositpaid", false);
//        jsonObjectUpdate.put("additionalneeds", "Computer Desk");
//        JSONObject bookingDates2 = new JSONObject();
//        bookingDates2.put("checkin", "2022-10-18");
//        bookingDates2.put("checkout", "2022-10-20");
//        jsonObjectUpdate.put("bookingdates", bookingDates);
//
//        System.out.println(String.format("https://restful-booker.herokuapp.com/booking/%s", newID));
//        Response responseUpdate = RestAssured.given().
//                auth().preemptive().basic("admin", "password123").
//                contentType(ContentType.JSON).body(jsonObjectUpdate.toString()).put( String.format("https://restful-booker.herokuapp.com/booking/%s", newID));
//        responseUpdate.prettyPrint();
//
//        // verify response is 200
//        Assert.assertEquals(responseUpdate.getStatusCode(), 200, "Response is not 200.");
//    }

    @Test
    public void updateBookingByPatchTest()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstname", "Teddy");
        jsonObject.put("lastname", "Nzioka");
        jsonObject.put("totalprice", 123);
        jsonObject.put("depositpaid", true);
        jsonObject.put("additionalneeds", "Computer Desk");
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2022-10-18");
        bookingDates.put("checkout", "2022-10-20");
        jsonObject.put("bookingdates", bookingDates);

        Response responseCreate = createNewBooking(jsonObject);
        responseCreate.prettyPrint();

        int newID = responseCreate.jsonPath().getInt("bookingid");

        JSONObject jsonObjectUpdate = new JSONObject();
        JSONObject bookingDatesUpdate = new JSONObject();
        bookingDatesUpdate.put("checkout", "2023-10-20");
        jsonObjectUpdate.put("additionalneeds", "not available");

        System.out.println(String.format("https://restful-booker.herokuapp.com/booking/12318", newID));
        Response responseUpdate = RestAssured.given().
                auth().preemptive().basic("admin", "password123").
                contentType(ContentType.JSON).body(jsonObjectUpdate.toString()).patch( String.format("https://restful-booker.herokuapp.com/booking/12318", newID));
        responseUpdate.prettyPrint();

        // verify response is 200
        Assert.assertEquals(responseUpdate.getStatusCode(), 200, "Response is not 200.");
    }
}

