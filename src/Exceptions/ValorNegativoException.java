package Exceptions;

public class ValorNegativoException extends Exception {

    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "Valor não pode ser negativo.";
    }
}