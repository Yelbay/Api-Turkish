package get_http_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest11  {

String endpoint= "https://www.gmibank.com/api/tp-customers";
String bearerToken="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZWFtMThfYWRtaW4iLCJhdXRoIjoiUk9MRV9BRE1JTiIsImV4cCI6MTY2NTE3NzU1NH0.vuz7w2aLV3YNfjR8A_bDUBfhbrsb7BCzqDRwR4DvC9_eIPrlS6s5n7lsMxA5477LZs4U8qqsiNaq-ilAZMoYrA";
@Test
    public void test(){
    Response response=given()
            .header("Authorization","Bearer "+ bearerToken)// Bearer den sonra bosluk guvenlik icin birakilmis
            .when().get(endpoint).then().extract().response();
    response.prettyPrint();

}





}
