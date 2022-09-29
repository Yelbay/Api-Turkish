package get_http_request;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest05 {
   /*

    accept type application "application/json"
    statuscode 200
    content type "application/json"
    and header "Server" is "cloudflare"
    and response body "userId"  7
    and "title"   esse et
    and "completed" false

Start to type Automation Scripts
            i) Set the URL
            ii)Set the expected the data(POST-PUT-PATCH)
            iii) Type the code to send request
            iv) Do Assertions
     */




    @Test
    public void test01(){
        String url="https://jsonplaceholder.typicode.com/todos/123";
        Response response=given().when().accept("application/json").get(url);
response.prettyPrint();
response.
        then().
        assertThat().
        contentType("application/json").
        statusCode(200).
        header("server",equalTo("cloudflare"));

response.then()
        .assertThat()
        .body("userId",equalTo(7),
                "title",equalTo("esse et quis iste est earum aut impedit" ),
                "completed",equalTo(false));
    }



}
