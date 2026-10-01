package sistemascorporativo.veiculoservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "veiculos")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String modelo;
    private Integer anoFabricacao;
    private String tipo;
    private String nomeProprietario;
}
