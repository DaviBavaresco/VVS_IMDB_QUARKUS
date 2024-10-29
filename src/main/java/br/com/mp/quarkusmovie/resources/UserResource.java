package br.com.mp.quarkusmovie.resources;

import br.com.mp.quarkusmovie.model.dto.UserDTO;
import br.com.mp.quarkusmovie.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserResource {

    @Inject
    UserService userService;

    @POST
    public Response create(UserDTO userDTO){
    userService.create(userDTO);
    return Response.status(Response.Status.CREATED).build();
    }
}
