package strategy;

import entidades.Aluguel;
import entidades.Carro;

public class AlugarContext {

	private AlugarStrategy strategy;

	public AlugarContext(AlugarStrategy strategy) {
		this.strategy = strategy;
	}
	
	public Aluguel alugar(Carro c, int dias) {
		return strategy.alugar(c, dias);
	}
	
}
