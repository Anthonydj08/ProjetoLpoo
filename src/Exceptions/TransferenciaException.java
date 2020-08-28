package Exceptions;

public class TransferenciaException extends Exception{

    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "A conta não possui saldo suficiente.";
    }
    
}