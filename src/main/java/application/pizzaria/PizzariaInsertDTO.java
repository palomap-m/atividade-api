package application.pizzaria;
 
import io.swagger.v3.oas.annotations.media.Schema;
 
@Schema(description = "DTO para criação/atualização de Pizzaria")
public record PizzariaInsertDTO(
    @Schema(description = "Nome da pizzaria", example = "Bella Napoli", requiredMode = Schema.RequiredMode.REQUIRED)
    String nome,
    @Schema(description = "CNPJ da pizzaria", example = "12.345.678/0001-90", requiredMode = Schema.RequiredMode.REQUIRED)
    String cnpj,
    @Schema(description = "Endereço da pizzaria", example = "Rua das Flores, 100 - São Paulo/SP", requiredMode = Schema.RequiredMode.REQUIRED)
    String endereco
) {
    public PizzariaInsertDTO(Pizzaria dados) {
        this(dados.getNome(), dados.getCnpj(), dados.getEndereco());
    }
}