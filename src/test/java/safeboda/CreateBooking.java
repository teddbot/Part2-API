package safeboda;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBooking extends BookingBase
{
  @Test
   public void createBookingTest()
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
    Assert.assertEquals(responseCreate.getStatusCode(), 200, "Response is not 200.");   }

}
