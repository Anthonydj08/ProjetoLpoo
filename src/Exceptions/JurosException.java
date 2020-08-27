package Exceptions;

public class JurosException extends Exception {

    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "Digite um valor entre 0.1 e 100.";
    }

}