package br.com.mp.quarkusmovie.resources;


import br.com.mp.quarkusmovie.model.dto.UserDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class UserResourceTest {


    @Test
    @DisplayName("Create user test")
    void createUserTest() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("cecilia@machado.com");
        userDTO.setName("Cecilia");
        userDTO.setPassword("cecilia123");
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
    void createDuplicatedUserTest() {
        UserDTO test1 = new UserDTO();
        test1.setEmail("davi@");
        test1.setName("davi");
        test1.setPassword("davi12345678");
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(test1)
                .post("/users")
                .then()
                .statusCode(400);
    }


    @Test
    @DisplayName("try to create user without name test")
    void createUserWithoutNameTest() {
        UserDTO test2 = new UserDTO();
        test2.setEmail("test2@");
        test2.setName("");
        test2.setPassword("test212345678");
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(test2)
                .post("/users")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("try to create user without password test")
    void createUserWithoutPasswordTest() {
        UserDTO test3 = new UserDTO();
        test3.setEmail("test3@");
        test3.setName("test3");
        test3.setPassword("");
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(test3)
                .post("/users")
                .then()
                .statusCode(400);
    }
}
