package sistemascorporativo.veiculoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistemascorporativo.veiculoservice.model.veiculo;

public interface veiculoRepository extends JpaRepository<veiculo, Long> {
    public veiculo save(veiculo veiculo);
}
