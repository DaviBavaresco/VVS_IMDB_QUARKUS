package br.com.mp.quarkusmovie.service;

import br.com.mp.quarkusmovie.exception.BusinessException;
import br.com.mp.quarkusmovie.model.Movie;
import br.com.mp.quarkusmovie.model.User;
import br.com.mp.quarkusmovie.model.UserMovie;
import br.com.mp.quarkusmovie.model.UserMoviePK;
import br.com.mp.quarkusmovie.model.dto.UserMovieModelAPI;
import br.com.mp.quarkusmovie.repository.MovieRepository;
import br.com.mp.quarkusmovie.repository.UserMovieRepository;
import br.com.mp.quarkusmovie.repository.UserRepository;
import br.com.mp.quarkusmovie.restclient.IMDBAPIRestClient;
import br.com.mp.quarkusmovie.restclient.model.MovieIMDB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotAuthorizedException;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MovieService {

    @ConfigProperty(name ="x-rapidapi-key")
    String xRapidapiKey;

    @ConfigProperty(name ="x-rapidapi-host")
    String xRapidapiHost;

    @Inject
    MovieRepository movieRepository;


    @Inject
    @RestClient
    IMDBAPIRestClient imdbapiRestClient;

    @Inject
    UserMovieRepository userMovieRepository;

    @Inject
    UserRepository userRepository;

    @Transactional
    public MovieIMDB search(String query) {
        MovieIMDB movieIMDB = imdbapiRestClient.search(xRapidapiKey,xRapidapiHost,query);


        saveMovie(movieIMDB);
        return movieIMDB;
    }

    private void saveMovie(MovieIMDB movieIMDB) {
        List<Movie> movies = new ArrayList<>();


        movieIMDB.getDescriptionIMDBS().forEach(m ->{
            Movie movieDatabase = movieRepository.findyIMDBID(m.getIdIMDB());

            if(movieDatabase == null && m.getQualifier() != null){
                movies.add(new Movie(m));
            }

            movieRepository.persist(movies);
        });
    }

    public List<Movie> list()  {
        return movieRepository.listAll();
    }

    public List<Movie> listBestRated() {
    return movieRepository.listBestRated();
    }
    @Transactional
    public Movie evaluate(UserMovieModelAPI userMovieModelAPI, String emailUser) {

        Optional<User> user = userRepository.findByEmail(emailUser);

        if(user.isEmpty()){
            throw new NotAuthorizedException("Erro ao obter credencias do usuario");
        }

        if(!userMovieModelAPI.getAreadyWatched()){
            throw new BusinessException("Erro: para dar uma avaliação é nescessario assistir o filme");
        }

        Movie movie = movieRepository.findyIMDBID(userMovieModelAPI.getMovieIMDBId());

        UserMoviePK userMoviePK =  new UserMoviePK();
        userMoviePK.setUserId(user.get().getId());
        userMoviePK.setMovieId(movie.getId());

        UserMovie userMovie = new UserMovie();
        userMovie.setMovie(movie);
        userMovie.setUserMoviePK(userMoviePK);
        userMovie.setIrAreadyWatched(userMovieModelAPI.getAreadyWatched());
        userMovie.setWatchlist(userMovieModelAPI.getWatchList());
        userMovie.setRate(userMovieModelAPI.getRate());


        userMovieRepository.getEntityManager().merge(userMovie);

        return movie;
    }
}
