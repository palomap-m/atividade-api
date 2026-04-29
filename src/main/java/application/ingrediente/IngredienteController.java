package application.ingrediente;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import org.springdoc.api.ErrorMessage;
 
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
 
@Tag(
    name = "Ingredientes",
    description = "Operações relacionadas aos ingredientes do estoque das pizzarias",
    externalDocs = @ExternalDocumentation(
        description = "Documentação Detalhada",
        url = "https://swagger.io/docs/"
    )
)
@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {
    @Autowired
    private IngredienteService ingredienteService;
 
    @PostMapping
    @Operation(summary = "Cadastra um novo ingrediente para uma pizzaria")
    @ApiResponse(responseCode = "200", description = "Ingrediente cadastrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Pizzaria não encontrada")
    public IngredienteDTO insert(@RequestBody IngredienteInsertDTO novoIngrediente) {
        return ingredienteService.insert(novoIngrediente);
    }
 
    @GetMapping("/{id}")
    @Operation(summary = "Retorna um ingrediente específico pelo ID")
    @ApiResponse(responseCode = "200", description = "Ingrediente retornado com sucesso")
    @ApiResponse(
        responseCode = "404",
        description = "Ingrediente não encontrado",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ErrorMessage.class)
        )
    )
    public IngredienteDTO getOne(
        @Parameter(description = "ID do ingrediente a ser consultado", example = "1", required = true)
        @PathVariable long id) {
        return ingredienteService.getOne(id);
    }
 
    @GetMapping
    @Operation(summary = "Lista todos os ingredientes, ou filtra por pizzaria se informado o parâmetro pizzariaId")
    @ApiResponse(responseCode = "200", description = "Lista de ingredientes retornada com sucesso")
    public Iterable<IngredienteDTO> getAll(
        @Parameter(description = "ID da pizzaria para filtrar ingredientes (opcional)", example = "1")
        @RequestParam(required = false) Long pizzariaId) {
        if (pizzariaId != null) {
            return ingredienteService.getByPizzaria(pizzariaId);
        }
        return ingredienteService.getAll();
    }
 
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza os dados de um ingrediente")
    @ApiResponse(responseCode = "200", description = "Ingrediente atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Ingrediente ou pizzaria não encontrada")
    public IngredienteDTO update(
        @PathVariable long id,
        @RequestBody IngredienteInsertDTO novosDados) {
        return ingredienteService.update(id, novosDados);
    }
 
    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um ingrediente pelo ID")
    @ApiResponse(responseCode = "200", description = "Ingrediente removido com sucesso")
    @ApiResponse(responseCode = "404", description = "Ingrediente não encontrado")
    public void remove(@PathVariable long id) {
        ingredienteService.delete(id);
    }
}