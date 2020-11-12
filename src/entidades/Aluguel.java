package entidades;

import java.util.Date;

public class Aluguel {

	private Imovel imovelAlugado;
	private Date dataAluguel;
	private Date validade;
	
	public Aluguel(Imovel imovelAlugado, Date dataAluguel, Date validade) {
		this.imovelAlugado = imovelAlugado;
		this.dataAluguel = dataAluguel;
		this.validade = validade;
	}
	
	public Imovel getImovelAlugado() {
		return imovelAlugado;
	}
	public void setImovelAlugado(Imovel imovelAlugado) {
		this.imovelAlugado = imovelAlugado;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Date getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(Date dataAluguel) {
		this.dataAluguel = dataAluguel;
	}
}
