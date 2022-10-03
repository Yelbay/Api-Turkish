package get_http_request;

import base_urls.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class GetRequest08 extends DummyBaseUrl {
    /*
    http://dummy.restapiexample.com/api/v1/employees
     */
    @Test
    public void test(){
        spec02.pathParams("first","api","second","v1","third","employees");
        Response response= given().spec(spec02).when().get("/{first}/{second}/{third}");
response.prettyPrint();
JsonPath json=response.jsonPath();
        System.out.println(json.getList("data.employee_name"));
        assertEquals("Cedric Kelly",json.getString("data[3].employee_name"));

    }
}
