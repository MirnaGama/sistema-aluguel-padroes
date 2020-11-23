package strategy;

import entidades.Aluguel;
import entidades.Carro;

public interface AlugarStrategy {

	public Aluguel alugar(Carro c, int dias);
	
}
