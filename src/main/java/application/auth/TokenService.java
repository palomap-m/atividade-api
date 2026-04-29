package application.auth;
 
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
 
@Service
public class TokenService {
    @Autowired
    private JwtConfig jwtConfig;
 
    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
 
    public String generateToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.jwtConfig.getSecret());
 
            return JWT.create()
                .withIssuer("PizzaStock API")
                .withSubject(usuario.getNomeDeUsuario())
                .withExpiresAt(this.expirationDate())
                .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar o token");
        }
    }
 
    public String getSubject(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.jwtConfig.getSecret());
            return JWT.require(algorithm)
                .withIssuer("PizzaStock API")
                .build()
                .verify(token)
                .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token Inválido");
        }
    }
}
