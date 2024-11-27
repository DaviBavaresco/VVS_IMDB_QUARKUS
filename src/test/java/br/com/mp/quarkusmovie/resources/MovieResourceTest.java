package br.com.mp.quarkusmovie.resources;

import br.com.mp.quarkusmovie.model.dto.UserMovieModelAPI;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
 class MovieResourceTest {

    @Inject
    LoginResourceTest loginResourceTest;

    String token = "";

    @BeforeEach
    public void getToken(){
        token = loginResourceTest.getToken();
    }
    @Test
    @DisplayName("Search movies")
    public void searchMovies(){
        String query = "Avengers";
        String imdbID = "tt4154796";

            given()
                .when()
                .get("/movies/search/{query}", query)
                .then()
                .statusCode(200)
                .body(containsString(imdbID))
                .extract()
                .jsonPath()
                .getString(imdbID);
    }



    @Test
    @DisplayName("Load list movies")
     void loadListMoviesTest() {
        given()
          .when().get("/movies/list")
          .then()
             .statusCode(200);
    }

    @Test
    @DisplayName("List best rated movies")
     void ListBestRatedTest(){
        given()
                .when()
                .get("/movies/listBestRated")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Rating/Evaluate movie")
     void evaluate(){
        UserMovieModelAPI userMovieModelAPI = new UserMovieModelAPI();
        userMovieModelAPI.setMovieIMDBId("tt8878862");
        userMovieModelAPI.setRate(4);
        userMovieModelAPI.setAreadyWatched(true);
        userMovieModelAPI.setWatchList(true);
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .body(userMovieModelAPI)
                .contentType(ContentType.JSON)
                .post("/movies/evaluate")
                .then()
                .statusCode(201);
    }


    @Test
    @DisplayName("Rating/Evaluate without token")
     void evaluateWithoutToken(){
        UserMovieModelAPI userMovieModelAPI = new UserMovieModelAPI();
        userMovieModelAPI.setMovieIMDBId("tt8878862");
        userMovieModelAPI.setRate(4);
        userMovieModelAPI.setAreadyWatched(true);
        userMovieModelAPI.setWatchList(true);
        given()
                .when()
                .body(userMovieModelAPI)
                .contentType(ContentType.JSON)
                .post("/movies/evaluate")
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("Rating/Evaluate movie watched = false")
     void evaluateWatchedFalse(){
        UserMovieModelAPI userMovieModelAPI = new UserMovieModelAPI();
        userMovieModelAPI.setMovieIMDBId("tt8878862");
        userMovieModelAPI.setRate(4);
        userMovieModelAPI.setAreadyWatched(false);
        userMovieModelAPI.setWatchList(true);
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .body(userMovieModelAPI)
                .contentType(ContentType.JSON)
                .post("/movies/evaluate")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("Rating/Evaluate movie without rate")
     void evaluateWithoutRate(){
        UserMovieModelAPI userMovieModelAPI = new UserMovieModelAPI();
        userMovieModelAPI.setMovieIMDBId("tt8878862");
        userMovieModelAPI.setAreadyWatched(false);
        userMovieModelAPI.setWatchList(true);
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .body(userMovieModelAPI)
                .contentType(ContentType.JSON)
                .post("/movies/evaluate")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("Rating/Evaluate movie with wronge IMDB")
     void evaluateWithWrongeIMDB(){
        UserMovieModelAPI userMovieModelAPI = new UserMovieModelAPI();
        userMovieModelAPI.setMovieIMDBId("tt88862");
        userMovieModelAPI.setAreadyWatched(true);
        userMovieModelAPI.setWatchList(true);
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .body(userMovieModelAPI)
                .contentType(ContentType.JSON)
                .post("/movies/evaluate")
                .then()
                .statusCode(400);
    }


    

}