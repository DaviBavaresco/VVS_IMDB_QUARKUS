package br.com.mp.quarkusmovie.model.dto;

public class UserMovieModelAPI {

    private String movieIMDBId;

    private Boolean areadyWatched;

    private Boolean watchList;

    private Integer rate;

    public String getMovieIMDBId() {
        return movieIMDBId;
    }

    public void setMovieIMDBId(String movieIMDBId) {
        this.movieIMDBId = movieIMDBId;
    }

    public Boolean getAreadyWatched() {
        return areadyWatched;
    }

    public void setAreadyWatched(Boolean areadyWatched) {
        this.areadyWatched = areadyWatched;
    }

    public Boolean getWatchList() {
        return watchList;
    }

    public void setWatchList(Boolean watchList) {
        this.watchList = watchList;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
