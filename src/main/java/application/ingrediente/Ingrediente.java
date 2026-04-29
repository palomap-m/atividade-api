package application.ingrediente;
 
import application.pizzaria.Pizzaria;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Entity
@Table(name = "ingredientes")
@Getter
@Setter
@NoArgsConstructor
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
    @Column(nullable = false)
    private String nome;
 
    @Column(name = "quantidade_estoque", nullable = false)
    private double quantidadeEstoque;
 
    @Column(name = "unidade_medida", nullable = false)
    private String unidadeMedida;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pizzaria_id", nullable = false)
    private Pizzaria pizzaria;
 
    public Ingrediente(IngredienteInsertDTO dados, Pizzaria pizzaria) {
        this.nome = dados.nome();
        this.quantidadeEstoque = dados.quantidadeEstoque();
        this.unidadeMedida = dados.unidadeMedida();
        this.pizzaria = pizzaria;
    }
}
