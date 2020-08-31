package Banco;

public abstract class Conta implements InterfaceConta {
	
	private int numero;
	protected double saldo;
	private Cliente titular;
	private Banco banco;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Cliente getTitular() {
		return titular;
	}
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	public Conta(int numero, double saldo, Cliente titular, Banco banco) {
		this.numero = numero;
		this.saldo = saldo;
		this.titular = titular;
		this.banco = banco;
	}
}
