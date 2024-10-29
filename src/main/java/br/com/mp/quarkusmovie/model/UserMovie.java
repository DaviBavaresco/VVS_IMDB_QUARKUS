package br.com.mp.quarkusmovie.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="user_movie")
public class UserMovie implements Serializable {
    @EmbeddedId
    protected UserMoviePK userMoviePK;

    private int rate;

    private boolean watchlist;

    private boolean irAreadyWatched;
    @JoinColumn(name="movie_id",referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Movie movie;

    public UserMoviePK getUserMoviePK() {
        return userMoviePK;
    }

    public void setUserMoviePK(UserMoviePK userMoviePK) {
        this.userMoviePK = userMoviePK;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public boolean isWatchlist() {
        return watchlist;
    }

    public void setWatchlist(boolean watchlist) {
        this.watchlist = watchlist;
    }

    public boolean isIrAreadyWatched() {
        return irAreadyWatched;
    }

    public void setIrAreadyWatched(boolean irAreadyWatched) {
        this.irAreadyWatched = irAreadyWatched;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
