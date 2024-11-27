package br.com.mp.quarkusmovie.resources;

import br.com.mp.quarkusmovie.model.dto.LoginDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class LoginResourceTest {

    final LoginDTO loginDTO = new LoginDTO();

    String token = "";
    
    @BeforeEach
    public void setUp(){
        loginDTO.setEmail("davi@");
        loginDTO.setPassword("davi123");
    }

    @Test
    @DisplayName("Login user")
    void login(){
        given()
                .contentType(ContentType.JSON)
                .body(loginDTO)
                .when().post("/login")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Login with wrong email")
     void loginError(){
        LoginDTO testWrongEmail = new LoginDTO();
        testWrongEmail.setEmail("aa");
        testWrongEmail.setPassword("davi123");
        given()
                .contentType(ContentType.JSON)
                .body(testWrongEmail)
                .when().post("/login")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("Login to get the token")
    void loginToken(){
        token = given()
                .contentType(ContentType.JSON)
                .body(loginDTO)
                .when().post("/login")
                .then()
                .statusCode(200)
                .extract().jsonPath().getString("token");
    }

    public String getToken(){
        setUp();
        loginToken();
        return token;
    }

}
