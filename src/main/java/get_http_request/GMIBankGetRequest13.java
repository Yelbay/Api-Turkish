package get_http_request;

import base_urls.GMIBankBAseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GMIBankGetRequest13 extends GMIBankBAseUrl {
String endpoint="https://www.gmibank.com/api/tp-customers/114351";
@Test
        public void test(){
    specGMI.pathParams("first","tp-customers","second","114351");
    Response response =given().spec(specGMI).header("Authorization","Bearer "+generateToken())
            .when().get("/{first}/{second}");
    response.prettyPrint();
    //JsonPath objesi create edip dogrulama yapma
    JsonPath json=response.jsonPath();
    Assert.assertEquals("Della",json.getString("firstName"));
    Assert.assertEquals("Heaney",json.getString("lastName"));
   Assert.assertEquals(69700,json.getInt("accounts.balance[0]"));

    //Matchers class ile dogrulama yapma
        response.then().assertThat().body("firstName",equalTo("Della"),
                                       "lastName",equalTo("Heaney"),
            "middleInitial",equalTo("Russell Homenick V"),
            "email",equalTo("ricardo.larkin@yahoo.com"),"mobilePhoneNumber",equalTo("123-456-7893"));
}







}
