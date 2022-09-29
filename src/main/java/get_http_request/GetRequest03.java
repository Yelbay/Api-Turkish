package get_http_request;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest03 {
    @Test
    public void get01(){
        String url="https://restful-booker.herokuapp.com/booking/7";
Response response=given().when().get(url);
//
response.then().statusCode(200).contentType("application/json").body("firstname",equalTo("Sally"),
        "lastname",equalTo("Brown"),
        "bookingdates.checkin",equalTo("2019-08-01"),
        "bookingdates.checkout",equalTo("2021-08-15"));
response.prettyPrint();




    }
}
