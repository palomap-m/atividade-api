package application.pizzaria;
 
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
 
@Service
public class PizzariaService {
    @Autowired
    private PizzariaRepository pizzariaRepo;
 
    public Iterable<PizzariaDTO> getAll() {
        return pizzariaRepo.findAll().stream().map(PizzariaDTO::new).toList();
    }
 
    public PizzariaDTO insert(PizzariaInsertDTO dados) {
        return new PizzariaDTO(pizzariaRepo.save(new Pizzaria(dados)));
    }
 
    public PizzariaDTO getOne(long id) {
        Optional<Pizzaria> resultado = pizzariaRepo.findById(id);
 
        if (resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizzaria não encontrada");
        }
 
        return new PizzariaDTO(resultado.get());
    }
 
    public PizzariaDTO update(long id, PizzariaInsertDTO novosDados) {
        Optional<Pizzaria> resultado = pizzariaRepo.findById(id);
 
        if (resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizzaria não encontrada");
        }
 
        resultado.get().setNome(novosDados.nome());
        resultado.get().setCnpj(novosDados.cnpj());
        resultado.get().setEndereco(novosDados.endereco());
 
        return new PizzariaDTO(pizzariaRepo.save(resultado.get()));
    }
 
    public void delete(long id) {
        if (!pizzariaRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizzaria não encontrada");
        }
        pizzariaRepo.deleteById(id);
    }
}