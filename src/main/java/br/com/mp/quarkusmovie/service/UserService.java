package br.com.mp.quarkusmovie.service;

import br.com.mp.quarkusmovie.exception.BusinessException;
import br.com.mp.quarkusmovie.model.User;
import br.com.mp.quarkusmovie.model.dto.UserDTO;
import br.com.mp.quarkusmovie.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;

import java.util.Optional;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;
    @Transactional
    public void create(UserDTO userDTO){

        Optional<User> userOptional = userRepository.findByEmail(userDTO.getEmail());


        if(userOptional.isPresent() ){
            throw new BusinessException("Usuario já cadastrado com este email");
        }


        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());


        userRepository.persist(user);
    }
}
