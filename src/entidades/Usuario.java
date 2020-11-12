package entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	// ele pode ser alguem interessado ou locador -- FUTURAMENTE REFATORAR E IMPLEMENTAR OBSERVER
	private List<Aluguel> imoveisAlugados;
	private List<Anuncio> imoveisAnunciados;
	
	public Usuario() {
		this.imoveisAlugados = new ArrayList<Aluguel>();
		this.imoveisAnunciados = new ArrayList<Anuncio>();
	}
	
	public List<Aluguel> getImoveisAlugados() {
		return imoveisAlugados;
	}
	public void setImoveisAlugados(List<Aluguel> imoveisAlugados) {
		this.imoveisAlugados = imoveisAlugados;
	}
	public List<Anuncio> getImoveisAnunciados() {
		return imoveisAnunciados;
	}
	public void setImoveisAnunciados(List<Anuncio> imoveisAnunciados) {
		this.imoveisAnunciados = imoveisAnunciados;
	}
	
	
}
