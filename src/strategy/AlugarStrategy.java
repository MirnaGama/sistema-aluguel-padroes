package strategy;

import java.util.Date;

import entidades.Aluguel;
import entidades.Carro;
import entidades.Usuario;

public interface AlugarStrategy {

	public Aluguel alugar(Carro c, Usuario u, Date validade);
	
}
