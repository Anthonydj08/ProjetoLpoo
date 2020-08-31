package Banco;

public class Banco {
	
	private int agencia;
	private String nomeagencia;
	
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public String getNomeagencia() {
		return nomeagencia;
	}
	public void setNomeagencia(String nomeagencia) {
		this.nomeagencia = nomeagencia;
	}
	public Banco(int agencia, String nomeagencia) {
		this.agencia = agencia;
		this.nomeagencia = nomeagencia;
	}
}
