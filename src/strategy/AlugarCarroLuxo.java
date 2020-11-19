package strategy;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import entidades.Aluguel;
import entidades.Carro;
import entidades.Usuario;

public class AlugarCarroLuxo implements AlugarStrategy {

	@Override
	public Aluguel alugar(Carro c, Usuario u, Date validade) {
		// TO-DO -- CARRO DE LUXO (60 REAIS POR DIA)
		Date hoje = new Date();
		
		// conversao de data para pegar diferenca de dias
		long diff = hoje.getTime() - validade.getTime(); 
		long diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
		double preco = diffDays * 60; // preco por dias
		
		Aluguel a = new Aluguel(c, hoje, validade, preco);
		return a;
	}


}
