package get_http_request;

import base_urls.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.AssertJUnit.*;

public class GetRequest09 extends DummyBaseUrl {
    /*
     //http://dummy.restapiexample.com/api/v1/employee/12
    body icerisindeki ids 5 olan datayi
            1) Matcher class ile
            2)JonPath ile dogrulayin

 */

    @Test
    public void test(){
        //http://dummy.restapiexample.com/api/v1/employee/12
        spec02.pathParams("first","api",
                "second","v1",
                "third","employee",
                "fourth","12");
        //Send request

Response response=given().spec(spec02).when().get("/{first}/{second}/{third}/{fourth}");
response.prettyPrint();
        System.out.println(response.getStatusCode());
//Assertion with Matchers class
response.then().statusCode(200).contentType(ContentType.JSON).
        body("data.employee_name", equalTo("Quinn Flynn"),
       "data.employee_salary", equalTo(342000),"data.employee_age", equalTo(  22));

////Assertion with JSON PATH
JsonPath json= response.jsonPath();
        System.out.println(json.getString("data.employee_name"));
       assertEquals("Quinn Flynn",json.getString("data.employee_name"));
       assertEquals(342000,json.getInt("data.employee_salary"));
        assertEquals(22,json.getInt("data.employee_age"));


    }




}
