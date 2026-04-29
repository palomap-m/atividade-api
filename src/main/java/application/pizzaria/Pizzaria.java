package application.pizzaria;
 
import java.util.List;
 
import application.ingrediente.Ingrediente;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Entity
@Table(name = "pizzarias")
@Getter
@Setter
@NoArgsConstructor
public class Pizzaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
    @Column(nullable = false)
    private String nome;
 
    @Column(nullable = false, unique = true)
    private String cnpj;
 
    @Column(nullable = false)
    private String endereco;
 
    @OneToMany(mappedBy = "pizzaria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingrediente> ingredientes;
 
    public Pizzaria(PizzariaInsertDTO dados) {
        this.nome = dados.nome();
        this.cnpj = dados.cnpj();
        this.endereco = dados.endereco();
    }
 
    public Pizzaria(PizzariaDTO dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.cnpj = dados.cnpj();
        this.endereco = dados.endereco();
    }
}