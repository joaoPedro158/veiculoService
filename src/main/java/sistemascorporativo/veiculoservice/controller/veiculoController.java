package sistemascorporativo.veiculoservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sistemascorporativo.veiculoservice.model.dto.veiculo.veiculoRequestDTO;
import sistemascorporativo.veiculoservice.model.dto.veiculo.veiculoResponseDTO;
import sistemascorporativo.veiculoservice.model.mapper.veiculoMapper;
import sistemascorporativo.veiculoservice.model.veiculo;
import sistemascorporativo.veiculoservice.service.veiculoService;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/veiculo")
public class veiculoController {

    private final veiculoService veiculoService;

    @PostMapping()
    public ResponseEntity<veiculoResponseDTO> salvarImovel(veiculoRequestDTO request) {
        veiculoResponseDTO imovelResponse = veiculoService.saveVeiculo(request);
        URI location = URI.create(String.format("/imovel/%s", imovelResponse.getId()));
        return ResponseEntity.created(location).body(imovelResponse);
    }

    @GetMapping()
    public ResponseEntity<List<veiculoResponseDTO>> listarVeiculos() {
        List<veiculoResponseDTO> veiculos = veiculoService.listarVeiculo();
        return ResponseEntity.ok(veiculos);
    }
}
