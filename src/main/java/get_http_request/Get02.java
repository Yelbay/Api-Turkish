package get_http_request;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get02 {
    @Test
    public void get01() {


        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);
        response.prettyPrint();
        System.out.println("Status Code=" + response.statusCode());
        //response.prettyPeek();//brings all from response
        response
                .then()
                .statusCode(200)
                .contentType("application/json");

//        response
//                .then().body("data.first_name",equalTo("George"),
//                "data.last_name",equalTo("Bluth"),
//                "data.email",equalTo("george.bluth@reqres.in"));

        response
                .then()
                .body("data[1].first_name",equalTo("Janet"),
                        "data[1].last_name",equalTo("Weaver"),
                        "data[1].email",equalTo("janet.weaver@reqres.in"));//"data[1].email",equalTo("")

    }
}