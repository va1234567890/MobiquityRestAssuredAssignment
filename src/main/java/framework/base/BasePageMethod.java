package framework.base;

import framework.Utilities.Constants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class BasePageMethod extends TestBase{

    public static RequestSpecification SetBaseUri()
    {
        RequestSpecification requestSpec = new RequestSpecBuilder().build();
        requestSpec.baseUri(Constants.BASEURL);

        return requestSpec;
    }

    public static void AssertStatusCode(int actualStatusCode, int expectedStatusCode)
    {
        if(actualStatusCode != expectedStatusCode)
        {
            Assert.assertEquals(actualStatusCode, expectedStatusCode);
        }
    }
}
