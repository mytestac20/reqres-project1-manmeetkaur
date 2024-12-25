package in.reqres.mytests;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class UsersListGetTest extends TestBase {
    @Test
    public void getListOfAllUsers() {

        Response response = given()
                .when()
                .get("/users");
        response.prettyPrint();
        response.then().statusCode(200);

        // Verify the status code and response body
        response.then().statusCode(200);
        response.then().body("page", equalTo(2));

        response.then()
                .body("page", equalTo(2)) // Verify the page number is 2
                //.body("data.size()", greaterThan(0)) // Check that there is at least one user in the data
                .body("data[0].id", notNullValue()) // Ensure the first user has an 'id'
                .body("data[0].first_name", notNullValue()) // Ensure the first user has a 'first_name'
                .body("data[0].last_name", notNullValue()) // Ensure the first user has a 'last_name'
                .body("data[0].avatar", containsString("https://reqres.in/img/faces/")) // Validate avatar URL
                .body("total_pages", greaterThanOrEqualTo(1));

    }
}
