package br.com.mp.quarkusmovie.model;

import br.com.mp.quarkusmovie.restclient.model.DescriptionIMDB;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;



@Entity
@Table(name="movie")
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name="imdb_id")
    private String imdbId;
    @Column(name="image_url")
    private String imagemUrl;

    private String qualifier;

    private Long rank;

    private String staff;

    private Long year;

    public Movie() {
    /*
     * Construtor vazio por causa do banco de dados que estamos usando
     */
    }

    public void naoFazNada(){
    }

    public Movie(DescriptionIMDB descriptionIMDB) {
        this.name = descriptionIMDB.getLongName();
        this.imdbId = descriptionIMDB.getIdIMDB();
        this.imagemUrl = descriptionIMDB.getImage().getImageUrl();
        this.qualifier = descriptionIMDB.getQualifier();
        this.rank = descriptionIMDB.getRank();
        this.staff = descriptionIMDB.getStaff();
        this.year = descriptionIMDB.getYear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }




}
