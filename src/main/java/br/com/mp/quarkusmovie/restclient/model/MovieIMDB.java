
package br.com.mp.quarkusmovie.restclient.model;


import jakarta.json.bind.annotation.JsonbProperty;

import java.util.List;

public class MovieIMDB {


    private List<DescriptionIMDB> descriptionIMDBS;

    private String query;

    public List<DescriptionIMDB> getDescriptionIMDBS() {
        return descriptionIMDBS;
    }
    @JsonbProperty("d")
    public void setDescriptionIMDBS(List<DescriptionIMDB> descriptionIMDBS) {
        this.descriptionIMDBS = descriptionIMDBS;
    }

    public String getQuery() {
        return query;
    }
    @JsonbProperty("q")
    public void setQuery(String query) {
        this.query = query;
    }
}
