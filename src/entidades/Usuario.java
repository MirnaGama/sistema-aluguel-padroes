package entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nome, cpf, email; // vamos usar somente esses atributos para o cadastro para ser mais rapido
	// ele pode ser alguem interessado ou locador -- FUTURAMENTE REFATORAR E IMPLEMENTAR OBSERVER
	private List<Aluguel> imoveisAlugados;
	private List<Anuncio> imoveisAnunciados;
	
	public Usuario(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.imoveisAlugados = new ArrayList<Aluguel>();
		this.imoveisAnunciados = new ArrayList<Anuncio>();
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
