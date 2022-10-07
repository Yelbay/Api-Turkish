package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utilities.Authentication;

public class GMIBankBAseUrl extends Authentication {
    protected RequestSpecification specGMI;

    @Before
    public void setup(){
        specGMI=new RequestSpecBuilder().setBaseUri("https://www.gmibank.com/api").build();
    }
}
