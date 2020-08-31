package Banco;

import Exceptions.SaldoException;
import Exceptions.TransferenciaException;
import Exceptions.ValorNegativoException;

public class ContaPoupanca extends Conta {

	private double juros;

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}
	
	public ContaPoupanca(int numero,double saldo,Cliente cliente,Banco banco, double juros) {
		super(numero, saldo, cliente, banco);
		this.juros = juros;
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

	public void realizadeposito(double deposito) {
		this.saldo = this.saldo + deposito;
	}
	public void realizatransferencia(Conta destino,double valordatransferencia) throws TransferenciaException {
		if (this.saldo - valordatransferencia < 0) {
			throw new TransferenciaException();
		} else {
			this.saldo = this.saldo - valordatransferencia;
			destino.saldo = destino.saldo + valordatransferencia;
		}
	}

	public void renderjuros() throws SaldoException {
		if (this.saldo <= 0) {
			throw new SaldoException();
		} else {
			this.saldo = this.saldo + (this.juros * this.saldo / 100);
		}

	}

}