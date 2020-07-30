package APITesting.apiCalls;

import framework.Utilities.Constants;
import framework.Utilities.CustomeException;
import framework.base.BasePageMethod;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class searchPostID extends BasePageMethod {

    // postID is made static to make more memory efficient
    static List<Integer> postID;

    public static void searchPostId(int userID, int responseStatusCode) throws CustomeException.IDNotFoundException {

        Response response = given()
                .spec(SetBaseUri())
                .param("userId", userID)
                .get("/posts");

        JsonPath extractor = response.jsonPath();
        AssertStatusCode(response.statusCode(), responseStatusCode);
        postID = extractor.getList("id");

        // validates whether key "id" is present or not in the response
        if (postID.size() == 0)
            throw new CustomeException.IDNotFoundException("Not found : postID for userID " + userID);

        log.info("post ids of " + userID + " is = " + postID);
    }

    public List<Integer> getPostID(String userName, int responseStatusCode) throws CustomeException.IDNotFoundException {
        // creating instance for searchUserID class
        searchUserID userid = new searchUserID();
        // userID received from getUserID method is stored in userID
        int userID = userid.getUserID(Constants.VALIDUSER, Constants.SUCCESSSTATUSCODE);
        // searchPostId called based on the userID
        searchPostId(userID, 200);
        return postID;
    }
}
