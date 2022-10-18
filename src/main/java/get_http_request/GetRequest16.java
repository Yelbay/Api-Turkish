package get_http_request;

import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest16 extends JsonPlaceHolderBaseUrl {
    @Test
    public void test1(){
     //Set the URL
        spec.pathParams("first","todos","second","7");
        //Expected Data
        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",7);
        expectedData.put("title","illo expedita consequatur quia in");
        expectedData.put("completed",false);
        System.out.println("Expected Data: " +expectedData);
        //Send Request and  get the cresponse
        Response response=given().spec(spec).when().get("/{first}/{second}");
       // https://jsonplaceholder.typicode.com/todos/7
        response.prettyPrint();
//Response response1=given().spec(spec).body(expectedData).when().post("/{first}/{second}");
       //Java to Json serialisation
        //Json to Java Deserialization
        // serialize ve deserialize icin dependencies JsonDataBin yukledik
        Map<String, Object>actualData=response.as(HashMap.class); //deserialization
        response.prettyPrint();
        Assert.assertEquals(expectedData,actualData);

    }

}
