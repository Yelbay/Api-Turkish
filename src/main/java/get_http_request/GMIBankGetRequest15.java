package get_http_request;

import base_urls.GMIBankBAseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GMIBankGetRequest15 extends GMIBankBAseUrl {
    @Test
    public void test() {

        specGMI.pathParams("first", "tp-customers", "second", "85694");

        Response response=given().spec(specGMI).header("Authorization","Bearer "+ generateToken()).when().get("/{first}/{second}");
        response.prettyPrint();
        //JsonPath ile assertion
        JsonPath json=response.jsonPath();
        Assert.assertEquals("Winona",json.getString("firstName"));
        //Matchers ile assertion
        response.then().assertThat().body("firstName", Matchers.equalTo("Winona"));
    }


}