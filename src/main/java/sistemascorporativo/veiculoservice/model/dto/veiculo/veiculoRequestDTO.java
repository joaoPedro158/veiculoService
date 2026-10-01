package sistemascorporativo.veiculoservice.model.dto.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class veiculoRequestDTO {

    @NotBlank
    private String placa;
    @NotBlank
    private String modelo;
    @NotNull
    private Integer anoFabricacao;
    @NotBlank
    private String tipo;
    @NotBlank
    private String nomeProprietario;
}
