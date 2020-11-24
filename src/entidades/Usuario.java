package entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario implements Observador {
	private String nome, cpf, email; // vamos usar somente esses atributos para o cadastro para ser mais rapido
	// ele pode ser SOMENTE interessado em alugar -- FUTURAMENTE REFATORAR E IMPLEMENTAR OBSERVER
	private List<Aluguel> locacoes;
	private List<String> notificacoes;

	public Usuario(String nome, String email, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.locacoes = new ArrayList<>();
		this.notificacoes = new ArrayList<>();
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
	public List<Aluguel> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Aluguel> locacoes) {
		this.locacoes = locacoes;
	}

	public void listarNotificacoes() {
		if (notificacoes.size() == 0) {
			System.out.println("\n-------------------------------");
			System.out.println("Nenhuma notificação encontrada.");
			System.out.println("-------------------------------\n");
		} else {
			System.out.println("-------------------------------\n");
			for (String s : notificacoes) {
				System.out.println(s);
			}
			System.out.println("-------------------------------\n");
		}
	}

	@Override
	public void notificarAnuncio(Veiculo veiculo) {
		this.notificacoes.add(this.nome +
							  ", um novo " +
							  veiculo.getModelo() +
							  ", " + veiculo.getAno() +
							  ", de cor " +
							  veiculo.getCor() +
							  " está disponível para aluguel!");
	}
}
