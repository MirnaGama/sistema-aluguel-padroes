package entidades;

import java.util.Date;

public class Aluguel {

	private Carro carro;
	private Date dataAluguel;
	private Date validade;
	private double preco;
	
	public Aluguel(Carro carro, Date dataAluguel, Date validade, double preco) {
		super();
		this.carro = carro;
		this.dataAluguel = dataAluguel;
		this.validade = validade;
		this.preco = preco;
	}
	
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public Date getDataAluguel() {
		return dataAluguel;
	}
	public void setDataAluguel(Date dataAluguel) {
		this.dataAluguel = dataAluguel;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
	
}
