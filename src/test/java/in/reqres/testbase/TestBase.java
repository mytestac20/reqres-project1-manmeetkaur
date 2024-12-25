package in.reqres.testbase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {
    @BeforeClass
    public void inIt(){
        RestAssured.baseURI="https://reqres.in";
        RestAssured.basePath="/api";
    }
}
