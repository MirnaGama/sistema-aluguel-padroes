package entidades;

public class Apartamento extends Imovel {

	private int andar;
	private int numero;
	private String nomePredio;
	
	public Apartamento(int andar, int numero, String nomePredio) {
		super();
		this.andar = andar;
		this.numero = numero;
		this.nomePredio = nomePredio;
	}
	
	public int getAndar() {
		return andar;
	}
	public void setAndar(int andar) {
		this.andar = andar;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNomePredio() {
		return nomePredio;
	}
	public void setNomePredio(String nomePredio) {
		this.nomePredio = nomePredio;
	}
	
	
}
