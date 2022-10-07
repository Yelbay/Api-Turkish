package get_http_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Authentication;

import static io.restassured.RestAssured.given;

public class GetRequest12 extends Authentication {
    //Authentication class 'in icindeki generateToken methodu kullanilacak
    String endpoint= "https://www.gmibank.com/api/tp-customers";
  @Test
  public void test(){
/*
given() genellikle requeste basmadan once content Type ,Body(requestBody) vb on kosullari bu kisma yaziyoruz
when() get() post(), put(),vb http request islemlerini when den sonra yaziyoruz
then() sonra tum dogrulamalar assertionlari yaziyoruz
 */
      Response response=given()
                      .header("Authorization","Bearer "+ generateToken())
                      .when()
                      .get(endpoint)
                      .then().extract().response();
                       response.prettyPrint();
               //assertion
      response.then().contentType(ContentType.JSON).statusCode(200);
  }

}
