package Exceptions;

public class SaqueNegativoException extends Exception {

    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "Saque não pode ser negativo.";
    }
}