package application.ingrediente;
 
import io.swagger.v3.oas.annotations.media.Schema;
 
@Schema(description = "DTO para criação/atualização de Ingrediente")
public record IngredienteInsertDTO(
    @Schema(description = "Nome do ingrediente", example = "Farinha de Trigo", requiredMode = Schema.RequiredMode.REQUIRED)
    String nome,
    @Schema(description = "Quantidade em estoque", example = "50.0", requiredMode = Schema.RequiredMode.REQUIRED)
    double quantidadeEstoque,
    @Schema(description = "Unidade de medida", example = "kg", requiredMode = Schema.RequiredMode.REQUIRED)
    String unidadeMedida,
    @Schema(description = "ID da pizzaria à qual este ingrediente pertence", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    long pizzariaId
) {
    public IngredienteInsertDTO(Ingrediente dados) {
        this(
            dados.getNome(),
            dados.getQuantidadeEstoque(),
            dados.getUnidadeMedida(),
            dados.getPizzaria().getId()
        );
    }
}