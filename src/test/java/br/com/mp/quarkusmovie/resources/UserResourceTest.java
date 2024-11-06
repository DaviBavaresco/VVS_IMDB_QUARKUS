package br.com.mp.quarkusmovie.resources;


import br.com.mp.quarkusmovie.model.dto.UserDTO;
import groovy.transform.Final;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class UserResourceTest {

    final UserDTO userDTO = new UserDTO();

    @BeforeEach
    public void setUp(){
        userDTO.setEmail("cecilia@machado.com");
        userDTO.setName("Cecilia");
        userDTO.setPassword("cecilia123");
    }
    @Test
    @DisplayName("Create user test")
    public void createUserTest() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(userDTO)
                .post("/users")
                .then()
                .statusCode(201);
    }

    @Test
    @DisplayName("Create duplicated user test")
    public void createDuplicatedUserTest() {
        UserDTO davi = new UserDTO();
        davi.setEmail("davi@");
        davi.setName("davi");
        davi.setPassword("davi12345678");
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(davi)
                .post("/users")
                .then()
                .statusCode(400);
    }
}
