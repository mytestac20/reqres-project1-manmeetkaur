package in.reqres.mytests;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserDeleteTest  extends TestBase {
    @Test

    public void deleteTheUsers(){
        given().log().all()
                .pathParam("id",8)
                .when()
                .delete("/users/{id}")
                .then()
                .statusCode(204);

        Response response = given().log().all()
                .pathParam("id", 8)
                .when()
                .get("/users/{id}");  // GET request to check the user

        // Step 3: Verify that the user no longer exists (should return 404)
        response.then().statusCode(404);

    }
}
