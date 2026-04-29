package application.auth;
 
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
 
import lombok.Getter;
import lombok.Setter;
 
@Configuration
@ConfigurationProperties(prefix = "security.jwt")
@Getter
@Setter
public class JwtConfig {
    private String secret;
}