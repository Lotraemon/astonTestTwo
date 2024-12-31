import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestEcho {
    String s = "This is expected to be sent back as part of response body.";
    Map<String, String> json = new HashMap<>() {{
        put("foo1", "bar1");
        put("foo2", "bar2");
    }};

    @Test
    public void getecho() {
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then().log().body()
                .assertThat()
                .statusCode(200)
                .and().body("args", Matchers.equalTo(json));

    }

    @Test
    public void postTest() {
        given()
                .contentType("text/plain").body(s)
                .baseUri("https://postman-echo.com")
                .when()
                .post("/post")
                .then().log().body()
                .assertThat()
                .statusCode(200)
                .and().body("data", Matchers.equalTo(s));
    }

    @Test
    public void post2Test() {
        given()
                .contentType("application/json").body(json)
                .baseUri("https://postman-echo.com")
                .when()
                .post("/post")
                .then().log().body()
                .assertThat()
                .statusCode(200)
                .and().body("data", Matchers.equalTo(json));
    } //500 c application/x-www-form-urlencoded в form

    @Test
    public void putTest() {
        given()
                .contentType("text/plain").body(s)
                .baseUri("https://postman-echo.com")
                .when()
                .put("/put")
                .then().log().body()
                .assertThat()
                .statusCode(200)
                .and().body("data", Matchers.equalTo(s));
    }

    @Test
    public void patchTest() {
        given()
                .contentType("text/plain").body(s)
                .baseUri("https://postman-echo.com")
                .when()
                .patch("/patch")
                .then().log().body()
                .assertThat()
                .statusCode(200)
                .and().body("data", Matchers.equalTo(s));
    }

    @Test
    public void deleteTest() {
        given()
                .contentType("text/plain").body(s)
                .baseUri("https://postman-echo.com")
                .when()
                .delete("/delete")
                .then().log().body()
                .assertThat()
                .statusCode(200)
                .and().body("data", Matchers.equalTo(s));
    }
}
