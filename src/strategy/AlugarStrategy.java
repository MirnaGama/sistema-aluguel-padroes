package strategy;

import java.util.Date;

import entidades.Aluguel;
import entidades.Carro;

public interface AlugarStrategy {

	public Aluguel alugar(Carro c, Date validade);
	
}
