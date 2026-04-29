package application.ingrediente;
 
import io.swagger.v3.oas.annotations.media.Schema;
 
@Schema(description = "DTO de leitura de Ingrediente")
public record IngredienteDTO(
    @Schema(description = "ID do ingrediente", requiredMode = Schema.RequiredMode.AUTO)
    long id,
    @Schema(description = "Nome do ingrediente", example = "Farinha de Trigo", requiredMode = Schema.RequiredMode.REQUIRED)
    String nome,
    @Schema(description = "Quantidade em estoque", example = "50.0", requiredMode = Schema.RequiredMode.REQUIRED)
    double quantidadeEstoque,
    @Schema(description = "Unidade de medida", example = "kg", requiredMode = Schema.RequiredMode.REQUIRED)
    String unidadeMedida,
    @Schema(description = "ID da pizzaria proprietária do ingrediente", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    long pizzariaId
) {
    public IngredienteDTO(Ingrediente dados) {
        this(
            dados.getId(),
            dados.getNome(),
            dados.getQuantidadeEstoque(),
            dados.getUnidadeMedida(),
            dados.getPizzaria().getId()
        );
    }
}