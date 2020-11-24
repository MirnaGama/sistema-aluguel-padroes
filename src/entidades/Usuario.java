package entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nome, cpf; // vamos usar somente esses atributos para o cadastro para ser mais rapido
	// ele pode ser SOMENTE interessado em alugar -- FUTURAMENTE REFATORAR E IMPLEMENTAR OBSERVER
	private List<Aluguel> locacoes;
	
	public Usuario(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.locacoes = new ArrayList<>();
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
	
	public List<Aluguel> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Aluguel> locacoes) {
		this.locacoes = locacoes;
	}
}
