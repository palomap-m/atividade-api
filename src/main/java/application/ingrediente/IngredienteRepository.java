package application.ingrediente;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
    public List<Ingrediente> findByPizzariaId(long pizzariaId);
}
 