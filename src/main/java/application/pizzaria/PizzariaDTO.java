package application.pizzaria;
 
import io.swagger.v3.oas.annotations.media.Schema;
 
@Schema(description = "DTO de leitura de Pizzaria")
public record PizzariaDTO(
    @Schema(description = "ID da pizzaria", requiredMode = Schema.RequiredMode.AUTO)
    long id,
    @Schema(description = "Nome da pizzaria", example = "Bella Napoli", requiredMode = Schema.RequiredMode.REQUIRED)
    String nome,
    @Schema(description = "CNPJ da pizzaria", example = "12.345.678/0001-90", requiredMode = Schema.RequiredMode.REQUIRED)
    String cnpj,
    @Schema(description = "Endereço da pizzaria", example = "Rua das Flores, 100 - São Paulo/SP", requiredMode = Schema.RequiredMode.REQUIRED)
    String endereco
) {
    public PizzariaDTO(Pizzaria dados) {
        this(dados.getId(), dados.getNome(), dados.getCnpj(), dados.getEndereco());
    }
}