package entidades;

public class Anuncio {

	private Carro carro;
	private boolean finalizado; // se foi finalizado ou nao
	
	public Anuncio(Carro carro, boolean finalizado) {
		super();
		this.carro = carro;
		this.finalizado = finalizado;
	}
	
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	
	
}
