package entidades;

public class Moto extends Veiculo {

	private String categoria;
	private String versao;
	
	public Moto(String fabricante, String modelo, int ano, String cor, String categoria, String versao) {
		super(fabricante, modelo, ano, cor);
		this.categoria = categoria;
		this.versao = versao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}
	
	

}
