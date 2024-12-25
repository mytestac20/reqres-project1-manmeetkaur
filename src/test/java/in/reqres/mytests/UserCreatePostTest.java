package in.reqres.mytests;

import in.reqres.model.UserPojo;
import in.reqres.testbase.TestBase;
import in.reqres.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UserCreatePostTest extends TestBase {
    @Test
    public void createUser() {

        String email = TestUtils.getRandomValue() + "Vicky123@reqres.in";

        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email);
        userPojo.setFirstName("Vicky");
        userPojo.setLastName("Ranson");


        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/api/users");
        response.prettyPrint();
        response.then().statusCode(201);
        response.then()
                .body("email", equalTo(email)) // Validate that the email matches the input email
                .body("first_name", equalTo("Vicky")) // Check that the first name is correct
                .body("last_name", equalTo("Ranson")) // Check that the last name is correct
                .body("avatar", equalTo("https://reqres.in/img/faces/11-image.jpg")) // Validate avatar URL
                .body("id", notNullValue()); // Verify that the ID is not null
    }
}
