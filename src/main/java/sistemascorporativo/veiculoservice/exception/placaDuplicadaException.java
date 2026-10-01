package sistemascorporativo.veiculoservice.exception;

public class placaDuplicadaException extends RuntimeException {
    public placaDuplicadaException(String placa) {
        super("Placa duplicada: " + placa);
    }
}
