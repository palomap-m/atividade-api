package application.ingrediente;
 
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
 
import application.pizzaria.Pizzaria;
import application.pizzaria.PizzariaRepository;
 
@Service
public class IngredienteService {
    @Autowired
    private IngredienteRepository ingredienteRepo;
 
    @Autowired
    private PizzariaRepository pizzariaRepo;
 
    public Iterable<IngredienteDTO> getAll() {
        return ingredienteRepo.findAll().stream().map(IngredienteDTO::new).toList();
    }
 
    public Iterable<IngredienteDTO> getByPizzaria(long pizzariaId) {
        if (!pizzariaRepo.existsById(pizzariaId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizzaria não encontrada");
        }
        return ingredienteRepo.findByPizzariaId(pizzariaId).stream().map(IngredienteDTO::new).toList();
    }
 
    public IngredienteDTO insert(IngredienteInsertDTO dados) {
        Optional<Pizzaria> pizzaria = pizzariaRepo.findById(dados.pizzariaId());
 
        if (pizzaria.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizzaria não encontrada");
        }
 
        return new IngredienteDTO(ingredienteRepo.save(new Ingrediente(dados, pizzaria.get())));
    }
 
    public IngredienteDTO getOne(long id) {
        Optional<Ingrediente> resultado = ingredienteRepo.findById(id);
 
        if (resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingrediente não encontrado");
        }
 
        return new IngredienteDTO(resultado.get());
    }
 
    public IngredienteDTO update(long id, IngredienteInsertDTO novosDados) {
        Optional<Ingrediente> resultado = ingredienteRepo.findById(id);
 
        if (resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingrediente não encontrado");
        }
 
        Optional<Pizzaria> pizzaria = pizzariaRepo.findById(novosDados.pizzariaId());
 
        if (pizzaria.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizzaria não encontrada");
        }
 
        resultado.get().setNome(novosDados.nome());
        resultado.get().setQuantidadeEstoque(novosDados.quantidadeEstoque());
        resultado.get().setUnidadeMedida(novosDados.unidadeMedida());
        resultado.get().setPizzaria(pizzaria.get());
 
        return new IngredienteDTO(ingredienteRepo.save(resultado.get()));
    }
 
    public void delete(long id) {
        if (!ingredienteRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingrediente não encontrado");
        }
        ingredienteRepo.deleteById(id);
    }
}