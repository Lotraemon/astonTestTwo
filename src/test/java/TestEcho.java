import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestEcho {
    @Test
    public void getecho(){
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("?foo1=bar1&foo2=bar2")
                .then()
                .assertThat()
                .statusCode(200);

    }
}
