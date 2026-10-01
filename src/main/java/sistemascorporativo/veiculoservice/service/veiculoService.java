package sistemascorporativo.veiculoservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sistemascorporativo.veiculoservice.model.dto.veiculo.veiculoRequestDTO;
import sistemascorporativo.veiculoservice.model.dto.veiculo.veiculoResponseDTO;
import sistemascorporativo.veiculoservice.model.mapper.veiculoMapper;
import sistemascorporativo.veiculoservice.model.veiculo;
import sistemascorporativo.veiculoservice.repository.veiculoRepository;

@Service
@AllArgsConstructor
public class veiculoService {
    private final veiculoRepository veiculoRepository;
    private final veiculoMapper veiculoMapper;

    public veiculoResponseDTO saveVeiculo(veiculoRequestDTO request) {
        veiculo veiculoModel = veiculoMapper.toModel(request);
        veiculo veiculoSalvo = veiculoRepository.save(veiculoModel);
        return veiculoMapper.toResponse(veiculoSalvo);
    }
}
