package br.csi.stockey.Infra;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.*;


@Service
public class TokenServiceJWT {

    private Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }


    public String gerarToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256("JWT");
            return JWT.create()
                    .withIssuer("API Stockey")
                    .withSubject(user.getUsername())
                    .withClaim("ROLE", user.getAuthorities().stream().toList().get(0).toString())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token", exception);
        }
    }



    public String getSubject(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256("JWT");
            return JWT.require(algorithm)
                    .withIssuer("API Stockey")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTCreationException exception){
            throw new RuntimeException("Token deu ruim", exception);
        }
    }
}
