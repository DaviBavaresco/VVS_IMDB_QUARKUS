package br.com.mp.quarkusmovie.util;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;

import br.com.mp.quarkusmovie.model.User;
import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;
@ApplicationScoped
public class GenerateToken {
    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String generateTokenJWT(User user){
        String token =
                Jwt.issuer(issuer)
                        .expiresAt(Instant.now().plus(Duration.ofHours(1)))
                        .upn(user.getEmail())
                        .groups(new HashSet<>(Arrays.asList("User")))
                        .sign();
        System.out.println(token);
        return token;
    }
}