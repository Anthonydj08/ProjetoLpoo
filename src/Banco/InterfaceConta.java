package Banco;

import Exceptions.SaldoException;
import Exceptions.SaqueNegativoException;

public interface InterfaceConta {
	
	public void realizadeposito(double deposito);
	public void realizasaque(double saque) throws SaldoException, SaqueNegativoException;

}