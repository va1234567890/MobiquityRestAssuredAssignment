package APITesting.testCases;

import framework.Utilities.Constants;
import framework.Utilities.CustomeException;
import framework.base.TestBase;
import org.testng.annotations.Test;

import static APITesting.apiCalls.searchEmailID.searchEmailId;

public class verifyEmailService extends TestBase {

    @Test(description = "verify emailid of valid post id")
    public void verifyEmailIDForValidPostID() throws CustomeException.IDNotFoundException {
        searchEmailId(81, Constants.SUCCESSSTATUSCODE);
    }

    @Test(description = "verify emailid of invalid post id")
    public void verifyEmailIDForInValidPostID() throws CustomeException.IDNotFoundException {
        searchEmailId(8100, Constants.NOTFOUNDSTATUSCODE);
    }

    @Test(description = "verify emailid of non integer post id")
    public void verifyEmailIDForNonIntegerPostID() throws CustomeException.IDNotFoundException {
        searchEmailId(8100, Constants.BADREQUESTSTATUSCODE);
    }

    @Test(description = "verify emailid of blank post id")
    public void verifyEmailIDForBlankPostID() throws CustomeException.IDNotFoundException {
        searchEmailId(Constants.BLANKID, Constants.SUCCESSSTATUSCODE);
    }
}
