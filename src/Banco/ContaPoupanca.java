package Banco;

import Exceptions.JurosException;
import Exceptions.SaldoException;
import Exceptions.ValorNegativoException;

public class ContaPoupanca extends Conta {

	private double juros;

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}
	
	public ContaPoupanca(String numero,double saldo,Cliente cliente,Banco banco, double juros) {
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
	public void realizatransferencia(Conta destino,double valordatransferencia) {
		this.saldo = this.saldo - valordatransferencia;
		destino.saldo = destino.saldo + valordatransferencia;
	}

	public void renderjuros(double juros) throws JurosException, SaldoException {
		if (juros > 100 || juros < 0.1) {
			throw new JurosException();
		} else if (saldo <= 0) {
			throw new SaldoException();
		} else {
			this.saldo = saldo + (juros * saldo / 100);
		}

	}

}