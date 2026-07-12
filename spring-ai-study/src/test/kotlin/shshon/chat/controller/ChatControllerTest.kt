package shshon.chat.controller

import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.hamcrest.Matchers.notNullValue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChatControllerTest {

    @LocalServerPort
    private var port: Int = 0

    @BeforeEach
    fun setUp() {
        RestAssured.port = port
    }

    @Test
    fun `POST chat 요청시 응답을 반환한다`() {
        RestAssured.given()
            .contentType(ContentType.JSON)
            .body("""{"message":"안녕"}""")
            .`when`()
            .post("/chat")
            .then()
            .statusCode(200)
            .body("message", notNullValue())
    }
}
