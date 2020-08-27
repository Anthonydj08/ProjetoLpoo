package Exceptions;

public class EncerrarException extends Exception{
    
    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "Conta possui saldo em aberto.";
    }
}