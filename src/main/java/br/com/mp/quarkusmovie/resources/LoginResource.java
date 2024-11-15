package br.com.mp.quarkusmovie.resources;

import br.com.mp.quarkusmovie.model.dto.LoginDTO;
import br.com.mp.quarkusmovie.model.dto.LoginResponseDTO;
import br.com.mp.quarkusmovie.service.LoginService;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;


@Path("/login")
public class LoginResource {

    @Inject
    LoginService loginService;
    @PermitAll
    @POST
    public LoginResponseDTO login(LoginDTO loginDTO){
    return loginService.login(loginDTO);
    }
}
