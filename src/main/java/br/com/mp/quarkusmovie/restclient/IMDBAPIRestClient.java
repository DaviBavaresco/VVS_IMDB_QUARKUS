package br.com.mp.quarkusmovie.restclient;

import br.com.mp.quarkusmovie.restclient.model.MovieIMDB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "restcliente-imdb-api")
@Produces(MediaType.APPLICATION_JSON)
public interface IMDBAPIRestClient {

    @GET
    @Path("/auto-complete")
    MovieIMDB search(@HeaderParam("X-RapidAPI-Key") String xRapidapiKey,
                     @HeaderParam("X-RapidAPI-Host") String xRapidapiHost,
                     @QueryParam("q") String query);
}
