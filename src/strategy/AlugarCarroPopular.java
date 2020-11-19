package strategy;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import entidades.Aluguel;
import entidades.Carro;
import entidades.Usuario;

public class AlugarCarroPopular implements AlugarStrategy {

	@Override
	public Aluguel alugar(Carro c, Date validade) {
		// CARRO POPULAR (20 REAIS POR DIA)
		Date hoje = new Date();
		
		// conversao de data para pegar diferenca de dias
		long diff = hoje.getTime() - validade.getTime(); 
		long diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
		double preco = diffDays * 20; // preco por dias
		
		Aluguel a = new Aluguel(c, hoje, validade, preco);
		return a;
	}

}
