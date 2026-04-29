package application.pizzaria;
 
import java.util.Optional;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface PizzariaRepository extends JpaRepository<Pizzaria, Long> {
    public Optional<Pizzaria> findByCnpj(String cnpj);
}