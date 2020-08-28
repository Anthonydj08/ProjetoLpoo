package Banco;

import Exceptions.SaldoException;
import Exceptions.ValorNegativoException;

public interface InterfaceConta {
	
	public void realizadeposito(double deposito) throws ValorNegativoException;
	public void realizasaque(double saque) throws SaldoException, ValorNegativoException;
	public void realizatransferencia(Conta destino,double valordatransferencia);

}