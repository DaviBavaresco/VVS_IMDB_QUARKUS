package br.com.mp.quarkusmovie.resources;
import br.com.mp.quarkusmovie.model.Movie;
import br.com.mp.quarkusmovie.restclient.model.DescriptionIMDB;
import br.com.mp.quarkusmovie.restclient.model.ImageIMDB;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    // teste unitario da classe movie
    @Test
    void testMovieConstructorWithDescriptionIMDB() {
        // cria objeto DescriptionIMDB
        DescriptionIMDB descriptionIMDB = new DescriptionIMDB();
        // cria image
        ImageIMDB image = new ImageIMDB();
        image.setImageUrl("http://image.com");
        descriptionIMDB.setLongName("The Avengers");
        descriptionIMDB.setIdIMDB("tt4154796");
        descriptionIMDB.setImage(image);
        descriptionIMDB.setQualifier("PG-13");
        descriptionIMDB.setRank(1L);
        descriptionIMDB.setStaff("Director: Joss Whedon");
        descriptionIMDB.setYear(2012L);

        // cria um objeto Movie usando o construtor
        Movie movie = new Movie(descriptionIMDB);

        // verifica os valores
        assertEquals("The Avengers", movie.getName());
        assertEquals("tt4154796", movie.getImdbId());
        assertEquals("http://image.com", movie.getImagemUrl());
        assertEquals("PG-13", movie.getQualifier());
        assertEquals(1L, movie.getRank());
        assertEquals("Director: Joss Whedon", movie.getStaff());
        assertEquals(2012L, movie.getYear());
    }

    @Test
    void testGettersAndSetters() {
        Movie movie = new Movie();
        movie.setName("The Avengers");
        movie.setImdbId("tt4154796");
        movie.setImagemUrl("http://image.com");

        assertEquals("The Avengers", movie.getName());
        assertEquals("tt4154796", movie.getImdbId());
        assertEquals("http://image.com", movie.getImagemUrl());
    }


    
}
