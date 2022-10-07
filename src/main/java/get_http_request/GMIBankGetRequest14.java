package get_http_request;

import base_urls.GMIBankBAseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GMIBankGetRequest14 extends GMIBankBAseUrl {
    //String endpoint="https://www.gmibank.com/api/tp-customers/110472";

    @Test
    public void test(){
        specGMI.pathParams("first","tp-customers","second","110472");

        Response response= given().spec(specGMI).header("Authorization","Bearer "+generateToken()).when().get("/{first}/{second}");
response.prettyPrint();
response.then().assertThat().statusCode(200);
JsonPath json=response.jsonPath();
Assert.assertEquals("Melva",json.getString("firstName"));
Assert.assertEquals(24105,json.getInt("country.id"));
//Matchers ile assertion
        response.then().assertThat().body("firstName", equalTo("Melva"));
//Matchers.hasSize()
        //Matchers.hasItem();
    }
}
