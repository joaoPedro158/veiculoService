package sistemascorporativo.veiculoservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sistemascorporativo.veiculoservice.exception.placaDuplicadaException;
import sistemascorporativo.veiculoservice.exception.veiculoNaoEncontradoException;
import sistemascorporativo.veiculoservice.model.dto.veiculo.veiculoRequestDTO;
import sistemascorporativo.veiculoservice.model.dto.veiculo.veiculoResponseDTO;
import sistemascorporativo.veiculoservice.model.mapper.veiculoMapper;
import sistemascorporativo.veiculoservice.model.veiculo;
import sistemascorporativo.veiculoservice.repository.veiculoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class veiculoService {
    private final veiculoRepository veiculoRepository;
    private final veiculoMapper veiculoMapper;

    public veiculoResponseDTO saveVeiculo(veiculoRequestDTO request) {
        veiculo veiculoModel = veiculoMapper.toModel(request);
        if(veiculoRepository.existsByPlaca(veiculoModel.getPlaca())){
            throw  new placaDuplicadaException(veiculoModel.getPlaca());
        }
        veiculo veiculoSalvo = veiculoRepository.save(veiculoModel);
        return veiculoMapper.toResponse(veiculoSalvo);
    }

    public List<veiculoResponseDTO> listarVeiculo() {
        List<veiculo> veiculos = veiculoRepository.findAll();


        return veiculoMapper.toListResponse(veiculos);
    }


    public veiculoResponseDTO buscarVeiculoPorId(Long id) {
        veiculo veiculo = veiculoRepository.findById(id).orElseThrow(
                () -> new veiculoNaoEncontradoException(id)
        );
        return veiculoMapper.toResponse(veiculo);
    }

    public void deletarVeiculoPorId(Long id) {

        veiculoRepository.deleteById(id);
    }

    public veiculoResponseDTO atualizarVeiculo(veiculoRequestDTO request, Long id) {
        veiculo veiculoModel = veiculoMapper.toModel(request);
        veiculo veiculoSalvo = veiculoRepository.findById(id).orElseThrow(
                () -> new veiculoNaoEncontradoException(id)
        );
        veiculoModel.setId(veiculoSalvo.getId());
        veiculo veiculoAtualizado = veiculoRepository.save(veiculoModel);

        return veiculoMapper.toResponse(veiculoAtualizado);
    }

    public List<veiculoResponseDTO> listarVeiculosFiltro(String tipo) {
        List<veiculo> veiculos = veiculoRepository.findBytipoContainingIgnoreCase(tipo);
        return veiculoMapper.toListResponse(veiculos);
    }
}
