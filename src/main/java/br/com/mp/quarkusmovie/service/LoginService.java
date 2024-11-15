package br.com.mp.quarkusmovie.service;

import br.com.mp.quarkusmovie.model.User;
import br.com.mp.quarkusmovie.model.dto.LoginDTO;
import br.com.mp.quarkusmovie.model.dto.LoginResponseDTO;
import br.com.mp.quarkusmovie.repository.UserRepository;
import br.com.mp.quarkusmovie.util.GenerateToken;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotAuthorizedException;

import java.util.Optional;
@ApplicationScoped
public class LoginService {
    @Inject
    GenerateToken generateToken;

    @Inject
    UserRepository userRepository;
    public LoginResponseDTO login(LoginDTO loginDTO){

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();

       Optional<User> user = userRepository.findByEmail(loginDTO.getEmail());
       if(user.isEmpty()){
           throw new NotAuthorizedException("Erro ao efetuar a autenticação");
       }
        String token = generateToken.generateTokenJWT(user.get());

       loginResponseDTO.setEmail(user.get().getEmail());
       loginResponseDTO.setToken(token);

       return loginResponseDTO;
    }
}
