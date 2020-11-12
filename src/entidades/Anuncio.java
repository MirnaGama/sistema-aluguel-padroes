package entidades;

public class Anuncio {

	private Imovel imovelAnunciado;
	private boolean finalizado; // se foi finalizado ou nao
	
	public Anuncio(Imovel imovelAnunciado, boolean finalizado) {
		this.imovelAnunciado = imovelAnunciado;
		this.finalizado = finalizado;
	}
	
	public Imovel getImovelAnunciado() {
		return imovelAnunciado;
	}
	public void setImovelAnunciado(Imovel imovelAnunciado) {
		this.imovelAnunciado = imovelAnunciado;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}	
	
}
