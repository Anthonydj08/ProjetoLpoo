package Exceptions;

public class SaldoException extends Exception {

    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "Conta não possui saldo suficiente.";
    }
}