package application.pizzaria;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    name = "Pizzarias",
    description = "Operações relacionadas às pizzarias cadastradas",
    externalDocs = @ExternalDocumentation(
        description = "Documentação Detalhada",
        url = "https://swagger.io/docs/"
    )
)
@RestController
@RequestMapping("/pizzarias")
public class PizzariaController {
    @Autowired
    private PizzariaService pizzariaService;
 
    @PostMapping
    @Operation(summary = "Cadastra uma nova pizzaria")
    @ApiResponse(responseCode = "200", description = "Pizzaria cadastrada com sucesso")
    public PizzariaDTO insert(@RequestBody PizzariaInsertDTO novaPizzaria) {
        return pizzariaService.insert(novaPizzaria);
    }
 
    @GetMapping("/{id}")
    @Operation(summary = "Retorna uma pizzaria específica pelo ID")
    @ApiResponse(responseCode = "200", description = "Pizzaria retornada com sucesso")
    @ApiResponse(
        responseCode = "404",
        description = "Pizzaria não encontrada",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ErrorMessage.class)
        )
    )
    public PizzariaDTO getOne(
        @Parameter(description = "ID da pizzaria a ser consultada", example = "1", required = true)
        @PathVariable long id) {
        return pizzariaService.getOne(id);
    }
 
    @GetMapping
    @Operation(summary = "Lista todas as pizzarias cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista de pizzarias retornada com sucesso")
    public Iterable<PizzariaDTO> getAll() {
        return pizzariaService.getAll();
    }
 
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza os dados de uma pizzaria")
    @ApiResponse(responseCode = "200", description = "Pizzaria atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Pizzaria não encontrada")
    public PizzariaDTO update(
        @PathVariable long id,
        @RequestBody PizzariaInsertDTO novosDados) {
        return pizzariaService.update(id, novosDados);
    }
 
    @DeleteMapping("/{id}")
    @Operation(summary = "Remove uma pizzaria pelo ID")
    @ApiResponse(responseCode = "200", description = "Pizzaria removida com sucesso")
    @ApiResponse(responseCode = "404", description = "Pizzaria não encontrada")
    public void remove(@PathVariable long id) {
        pizzariaService.delete(id);
    }
}