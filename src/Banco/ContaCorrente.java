package Banco;

import Exceptions.SaldoException;
import Exceptions.ValorNegativoException;

public class ContaCorrente extends Conta {

	public ContaCorrente(String numero, double saldo, Cliente cliente, Banco banco) {
		super(numero, saldo, cliente, banco);
	}

	public void realizasaque(double saque) throws SaldoException, ValorNegativoException {
		if (saque > this.saldo) {
			throw new SaldoException();
		} else if (saque <= 0) {
			throw new ValorNegativoException();
		} else {
			this.saldo = this.saldo - saque;
		}
	}

	public void realizadeposito(double deposito) throws ValorNegativoException {
		if (deposito <= 0) {
			throw new ValorNegativoException();
		}
		
		this.saldo = this.saldo + deposito;
	}
	public void realizatransferencia(Conta destino,double valordatransferencia) {
		if(this.saldo - valordatransferencia>=0) {
		this.saldo = this.saldo - valordatransferencia;
		destino.saldo = destino.saldo + valordatransferencia;
		}else {
			System.out.println("A conta não tem este valor para transferir");
		}
	}
}