package get_http_request;

import base_urls.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class GetRequest10 extends DummyBaseUrl{
    @Test
    public void test(){
         /*

    body icerisindeki ids 5 olan datayi
            1) Matcher class ile
            2)JonPath ile dogrulayin
            status code 200
            5. employee name Airi Satou
            6. employee salary  is 372000

 */
        //http://dummy.restapiexample.com/api/v1/employee
        spec02.pathParams("first","api",
                "second","v1",
                "third","employee");
        Response response=given().spec(spec02).when().get("/{first}/{second}/{third}");
       response.prettyPrint();
  JsonPath json=response.jsonPath();
Assert.assertEquals("Airi Satou",json.getString("data[4].employee_name"));

    }

}
