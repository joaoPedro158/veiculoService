package sistemascorporativo.veiculoservice.model.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import sistemascorporativo.veiculoservice.model.dto.veiculo.veiculoRequestDTO;
import sistemascorporativo.veiculoservice.model.dto.veiculo.veiculoResponseDTO;
import sistemascorporativo.veiculoservice.model.veiculo;

import java.util.List;

@Mapper(componentModel = "spring")
public interface veiculoMapper {


    veiculo toModel(veiculoRequestDTO request);

    veiculoResponseDTO toResponse(veiculo veiculoSalvo);

    List<veiculoResponseDTO> toListResponse(List<veiculo> veiculos);
}
