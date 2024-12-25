package in.reqres.mytests;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserLoginSuccessfulPostTest extends TestBase {
    @Test
    public void verifyUserLoginSuccessFull(){
        Response response= given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body("{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }")
                .post("/api/login");
        response.prettyPrint();
        response.then().statusCode(201);


    }
}
