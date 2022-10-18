package get_http_request;

import base_urls.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest17GrowyLangAssert extends DummyBaseUrl {
    RequestSpecification spec;

    @Test
    public void test(){

 spec02.pathParams("1","api","2","v1","3","employees");
    Response response=given().spec(spec02).when().get("/{1}/{2}/{3}");
    response.prettyPrint();
     Assert.assertEquals(200,response.statusCode());
     JsonPath json=response.jsonPath();

     //Groovy ile loop kullanmadan responsedan gelen bilgileri sarta gore alabiliriz
     List<Integer> idList=json.getList("data.findAll{it.id>10}.id");//Groovy language
        System.out.println(idList);//[11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
      List<Integer>agesList=json.getList("data.findAll{it.employee_age>30}.employee_age");
        System.out.println(agesList);//[61, 63, 66, 33, 61, 59, 55, 39, 36, 43, 66, 64, 59, 41, 35, 40]
Collections.sort(agesList);
       // Assert.assertEquals(23,(int)agesList.get(agesList.size()-1)); iki sekilde yapabiliriz
        Assert.assertEquals((Integer)66,agesList.get(agesList.size()-1));// explicit narroving
        List<Integer>salaryList=json.getList("data.findAll{it.employee_salary>35000}.employee_name");
        System.out.println(salaryList);
        Assert.assertTrue(salaryList.contains(("Charde Marshall")));
    }
}
