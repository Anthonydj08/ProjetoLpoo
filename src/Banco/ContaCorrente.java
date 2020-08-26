package Banco;

public class ContaCorrente extends Conta {

	public ContaCorrente(String numero, Banco banco, double saldo, Cliente titular) {
		super(numero, banco, saldo, titular);
	}

	public void realizasaque(double saque) throws SaldoException {

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