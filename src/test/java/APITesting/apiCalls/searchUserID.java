package APITesting.apiCalls;

import framework.Utilities.CustomeException;
import framework.base.BasePageMethod;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class searchUserID extends BasePageMethod {

    // userID is made static to make more memory efficient
    static int userID;

    public static void searchUserId(String user, int responseStatusCode) throws CustomeException.IDNotFoundException {

        Response response = given()
                .spec(SetBaseUri())
                .param("username", user)
                .get("/users");

        JsonPath extractor = response.jsonPath();
        AssertStatusCode(response.statusCode(), responseStatusCode);
//        String ID = extractor.getString("id");
//        ID = ID.replace("[", "");
//        ID = ID.replace("]", "");
//        userID = Integer.parseInt(ID);

        userID = extractor.getInt("[0].id");

        // validates whether key "id" is present or not in the response
        if (userID == 0) {
            throw new CustomeException.IDNotFoundException("Not found : '" + user + "' user");
        }

        log.info("user id of " + user + " is = " + userID);
    }

    public int getUserID(String username, int responseStatusCode) throws CustomeException.IDNotFoundException {
        // searchUserID is called
        searchUserId(username, responseStatusCode);
        return userID;
    }
}
