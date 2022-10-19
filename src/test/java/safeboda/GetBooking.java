package safeboda;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetBooking
{

    @Test
    public void getBookingByIDTest()
    {
        // Not a BDD style test

        // get response
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/12318");

        response.print();

        // verify response is 200
        Assert.assertEquals(response.getStatusCode(), 200, "Response is not 200.");

        // At least 1 booking ID in response
        String name = response.jsonPath().get("firstname");
        String lastName = response.jsonPath().get("lastname");
        int totalPrice = response.jsonPath().getInt("totalprice");
        String checkin = response.jsonPath().getString("bookingdates.checkin");
        String checkout = response.jsonPath().getString("bookingdates.checkout");


        SoftAssert softAss = new SoftAssert();
        softAss.assertEquals(name, "Teddy", "Name is not as expected.");
        softAss.assertEquals(lastName, "Nzioka", "Last name is not as expected.");
        softAss.assertEquals(totalPrice, 123, "Total price not as expected.");
        softAss.assertEquals(checkin, "2022-10-18", "Check In Date not as expected.");
        softAss.assertEquals(checkout, "2022-10-20", "Check Out Date not as expected.");

        softAss.assertAll();
    }
}
