package in.reqres.mytests;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UserSingleGetTest extends TestBase {
    @Test
    public void getSingleUserInformation() {

        Response response = given()
                .pathParam("id", 8)
                .when()
                .get("/users/{id}");
        response.prettyPrint();
        response.then().statusCode(200);

        response.then()
                .body("data.id", equalTo(8)) // Verify user ID is 8
                .body("data.first_name", notNullValue()) // Verify first name is not null
                .body("data.last_name", notNullValue()); // Verify last name is not null

    }
}
