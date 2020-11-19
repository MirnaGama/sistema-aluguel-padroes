package entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nome, cpf, email; // vamos usar somente esses atributos para o cadastro para ser mais rapido
	// ele pode ser SOMENTE interessado em alugar -- FUTURAMENTE REFATORAR E IMPLEMENTAR OBSERVER
	private List<Aluguel> locacoes;
	
	public Usuario(String nome, String email, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.locacoes = new ArrayList<Aluguel>();
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
	
}
