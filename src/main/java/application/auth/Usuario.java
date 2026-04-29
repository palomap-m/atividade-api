package application.auth;
 
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Entidade de Usuários do Sistema")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
    @Column(name = "nome_de_usuario", nullable = false, unique = true)
    @Schema(example = "admin", description = "Nome de Usuário Único")
    private String nomeDeUsuario;
 
    @Column(nullable = false)
    @Schema(example = "12345", description = "Senha de Usuário")
    private String senha;
}
