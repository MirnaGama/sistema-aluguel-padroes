package entidades;

import java.util.Date;

public class Aluguel {

	private Veiculo v;
	private Date dataAluguel;
	private Date validade;
	private double preco;
	
	public Aluguel(Veiculo v, Date dataAluguel, Date validade, double preco) {
		super();
		this.v = v;
		this.dataAluguel = dataAluguel;
		this.validade = validade;
		this.preco = preco;
	}
	
	public Veiculo getVeiculo() {
		return v;
	}
	public void setVeiculo(Veiculo v) {
		this.v = v;
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
