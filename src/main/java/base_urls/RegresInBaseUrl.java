package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RegresInBaseUrl {
 protected RequestSpecification spec01;
@Before
public void setUp(){
    spec01=new RequestSpecBuilder().setBaseUri("https://reqres.in").build();
}
}
