package sistemascorporativo.veiculoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistemascorporativo.veiculoservice.model.veiculo;

import java.util.Optional;

public interface veiculoRepository extends JpaRepository<veiculo, Long> {
    public veiculo save(veiculo veiculo);

    public Optional<veiculo> findById(Long id);
}
