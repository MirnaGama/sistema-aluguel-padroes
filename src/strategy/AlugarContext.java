package strategy;

import java.util.Date;

import entidades.Aluguel;
import entidades.Carro;

public class AlugarContext {

	private AlugarStrategy strategy;

	public AlugarContext(AlugarStrategy strategy) {
		this.strategy = strategy;
	}
	
	public Aluguel alugar(Carro c, Date validade) {
		return strategy.alugar(c, validade);
	}
	
}
