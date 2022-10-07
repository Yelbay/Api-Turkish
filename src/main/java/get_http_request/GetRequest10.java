package get_http_request;

import base_urls.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
7) 24 employees
8)21 23 ve 61 yaslarinda calisan varmi
 */
        //http://dummy.restapiexample.com/api/v1/employees
        spec02.pathParams("first","api",
                "second","v1",
                "third","employees");
        Response response=given().spec(spec02).when().get("/{first}/{second}/{third}");
       response.prettyPrint();
    JsonPath json=response.jsonPath();
     Assert.assertEquals(200,response.statusCode());
     Assert.assertEquals("Airi Satou",json.getString("data[4].employee_name"));
     //6. employee salary  is 372000
     Assert.assertEquals(372000,json.getInt("data[5].employee_salary"));
     //     7) 24 employees
     Assert.assertEquals(24,json.getList("data.id").size());
    //    8)21 23 ve 61 yaslarinda calisan varmi
        //1.way
      List<Integer>ages=new ArrayList<>();
         ages.add(21);
        ages.add(23);
        ages.add(61);
        Assert.assertTrue(json.getList("data.employee_age").containsAll(ages));
       //2.way
        List<Integer>list= Arrays.asList(21,23,61);

        Assert.assertTrue(json.getList("data.employee_age").containsAll(list));




    }

}
