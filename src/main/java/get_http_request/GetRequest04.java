package get_http_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequest04 {

/*
https://dummy.restapiexample.com/api/v1/employees go to url
Check the status code 200 content type "application/json"
and number of employees 24
and one of employee's name is "Ashton Cox"
and ages 21,61,and 23


 */
        @Test
        public void get01(){
        String url="https://dummy.restapiexample.com/api/v1/employees";

Response response=given().when().get(url);
response.prettyPrint();
response.prettyPeek();
response.then().log().all();//it brings all thing in the response
response.then().assertThat().contentType("application/json").statusCode(200);
response.then().assertThat().body("data",hasSize(24),"data.employee_name",hasItem("Ashton Cox"),"data.employee_age",hasItems(21,61,23));

    }

}
