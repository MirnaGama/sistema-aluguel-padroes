package entidades;

import java.util.ArrayList;
import java.util.List;

import obs.Observador;

public class Usuario implements Observador {

	private String nome, cpf; // vamos usar somente esses atributos para o cadastro para ser mais rapido
	private List<Aluguel> locacoes;
	private List<String> notificacoes;
	
	public Usuario(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
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
	
	public List<Aluguel> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Aluguel> locacoes) {
		this.locacoes = locacoes;
	}
	
	public void listarNotificacoes() {
		if (this.notificacoes.size() == 0) {
			System.out.println("\n--------------------------------------------------------------");
			System.out.println("Nenhuma notificacao encontrada.");
			System.out.println("--------------------------------------------------------------\n");
		} else {
			System.out.println("\n--------------------------------------------------------------");
			for (String s : this.notificacoes) {
				System.out.println(s);
			}
			System.out.println("--------------------------------------------------------------\n");
		}
	}

	@Override
	public void notificarAnuncio(Veiculo veiculo) {
		this.notificacoes.add("Um novo veiculo do tipo "+veiculo.getTipo()+", "+
							  veiculo.getModelo() +
							  ", " + veiculo.getAno() +
							  ", de cor " +
							  veiculo.getCor() +
							  " esta disponivel para aluguel!");

		//System.out.println(this.notificacoes);
	}
	
}
