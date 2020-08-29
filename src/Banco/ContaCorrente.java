package Banco;

import Exceptions.SaldoException;
import Exceptions.TransferenciaException;
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

	public void realizatransferencia(Conta destino, double valordatransferencia) throws TransferenciaException {
		if (this.saldo - valordatransferencia < 0) {
			throw new TransferenciaException();
		} else {
			this.saldo = this.saldo - valordatransferencia;
			destino.saldo = destino.saldo + valordatransferencia;
		}
	}
}