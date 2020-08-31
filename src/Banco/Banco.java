package Banco;

public class Banco {
	
	private int agencia;
	private int nomeagencia;
	
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getNomeagencia() {
		return nomeagencia;
	}
	public void setNomeagencia(int nomeagencia) {
		this.nomeagencia = nomeagencia;
	}
	public Banco(int agencia, int nomeagencia) {
		this.agencia = agencia;
		this.nomeagencia = nomeagencia;
	}
}
