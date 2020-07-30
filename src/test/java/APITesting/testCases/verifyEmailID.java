package APITesting.testCases;

import framework.Utilities.Constants;
import framework.Utilities.CustomeException;
import framework.base.TestBase;
import org.testng.annotations.Test;

import static APITesting.apiCalls.searchEmailID.verifyEmailID;

public class verifyEmailID extends TestBase {

    @Test(description = "verify emailid of valid user")
    public void verifyEmailIDForValidUser() throws CustomeException.IDNotFoundException {
        verifyEmailID(Constants.VALIDUSER, Constants.SUCCESSSTATUSCODE);
    }

}
