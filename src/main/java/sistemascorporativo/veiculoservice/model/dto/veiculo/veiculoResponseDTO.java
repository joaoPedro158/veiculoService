package sistemascorporativo.veiculoservice.model.dto.veiculo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class veiculoResponseDTO {

    private Long id;
    private String plava;
    private String modelo;
    private Integer anoFabricacao;
    private String nomeProprietario;
}
