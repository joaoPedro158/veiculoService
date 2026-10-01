package sistemascorporativo.veiculoservice.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<veiculoResponseDTO> salvarVeiculo(@RequestBody @Valid veiculoRequestDTO request) {
        veiculoResponseDTO veiculoResponse = veiculoService.saveVeiculo(request);
        URI location = URI.create(String.format("/veiculo/%s", veiculoResponse.getId()));
        return ResponseEntity.created(location).body(veiculoResponse);
    }

    @GetMapping()
    public ResponseEntity<List<veiculoResponseDTO>> listarVeiculos() {
        List<veiculoResponseDTO> veiculos = veiculoService.listarVeiculo();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/tipo")
    public ResponseEntity<List<veiculoResponseDTO>> listarVeiculosFiltro(@RequestParam String tipo) {
        List<veiculoResponseDTO> veiculos = veiculoService.listarVeiculosFiltro(tipo);
        return ResponseEntity.ok(veiculos);
    }



    @GetMapping("/{id}")
    public ResponseEntity<veiculoResponseDTO> getVeiculo(@PathVariable Long id) {
        veiculoResponseDTO veiculo = veiculoService.buscarVeiculoPorId(id);
        return  ResponseEntity.ok(veiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarVeiculo(@PathVariable Long id) {
        veiculoService.deletarVeiculoPorId(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<veiculoResponseDTO> listarVeiculos(@RequestBody @Valid veiculoRequestDTO request, @PathVariable Long id) {
        veiculoResponseDTO veiculos = veiculoService.atualizarVeiculo(request, id);
        return ResponseEntity.ok(veiculos);
    }

}
