package get_http_request;

import base_urls.RegresInBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.AssertJUnit.*;

public class GetRequest07 extends RegresInBaseUrl {
/*
    //https://www.regres.in/api/users URL request olustur
    body icerisindeki ids 5 olan datayi
            1) Matcher class ile
            2)JonPath ile dogrulayin

 */
    @Test
    public void test(){
        //Set the Url
        spec01.pathParams("parametre1","api","parametre2","users");
        //https://www.regres.in/

        //send request get the response
        Response response=given().spec(spec01).when().get("/{parametre1}/{parametre2}");
        // response.prettyPrint();
         response.then().assertThat().body("data[3].email",equalTo("eve.holt@reqres.in"),
                 "data[3].first_name",equalTo("Eve"),"data[3].last_name",equalTo("Holt"));
//response.prettyPrint();

         //JsonPath
        JsonPath json=response.jsonPath();
        System.out.println(json.getList("data.email"));
        System.out.println(json.getList("data.first_name"));
        System.out.println(json.getList("data.last_name"));
        //3.calisanin emailini getiriniz
        assertEquals("charles.morris@reqres.in",json.getString("data[4].email"));
       // 3.calisanin ismini getirir
        assertEquals("Charles",json.getString("data[4].first_name"));
         System.out.println(json.getString("data[3].email"));
         //ilk 5 calisanin ismini getirir
        //1.way
        for(int i=0; i<5;i++){
            System.out.println(i+1+".= " +json.getString("data["+ i +"].first_name"));
        }
        //2.way
        System.out.println(json.getString("data.first_name[0,1,2,3,4]"));
        System.out.println(json.getString("data[-1].first_name"));//listededki son kisisyi verir
    }
}
