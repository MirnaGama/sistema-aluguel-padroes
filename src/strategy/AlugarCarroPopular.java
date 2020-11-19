package strategy;

import java.util.Date;

import entidades.Aluguel;
import entidades.Carro;
import entidades.Usuario;

public class AlugarCarroPopular implements AlugarStrategy {

	@Override
	public Aluguel alugar(Carro c, Usuario u, Date validade) {
		// TO-DO -- CARRO DE LUXO (60 REAIS POR DIA)
		return null;
	}

}
