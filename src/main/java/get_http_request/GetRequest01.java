package get_http_request;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;



import static io.restassured.RestAssured.given;


public class GetRequest01 {


    @Test
    public void test01(){
String url="https://restful-booker.herokuapp.com/booking";
Response response=given().when().get(url);
//response.prettyPrint();
        System.out.println("Status Code:"+ response.statusCode());//200
        System.out.println("Content Type:"+ response.contentType());//application/json;
        System.out.println("Test Time:"+ response.time());//
        System.out.println("Status Line="+response.statusLine());
        Assert.assertEquals(200,response.statusCode());

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json");
response.then().assertThat().statusCode(200).contentType("application/Json");

    }

}
