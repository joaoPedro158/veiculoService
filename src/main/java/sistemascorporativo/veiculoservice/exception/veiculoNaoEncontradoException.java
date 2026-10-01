package sistemascorporativo.veiculoservice.exception;

public class veiculoNaoEncontradoException extends RuntimeException {
    public veiculoNaoEncontradoException(Long id) {
        super("Voce nao encontrado com o id " + id);
    }
}
