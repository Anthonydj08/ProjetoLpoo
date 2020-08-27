package Banco;

import Exceptions.SaldoException;
import Exceptions.SaqueNegativoException;

public class ContaCorrente extends Conta {

	public ContaCorrente(String numero, double saldo, Cliente cliente, Banco banco) {
		super(numero, saldo, cliente, banco);
	}

	public void realizasaque(double saque) throws SaldoException, SaqueNegativoException {

		if (saque > this.saldo) {
            throw new SaldoException();
        }

        if (saque < 0) {
            throw new SaqueNegativoException();
        }

        this.saldo = this.saldo - saque;
	}

	public void realizadeposito(double deposito) {
		this.saldo = this.saldo + deposito;
	}
}