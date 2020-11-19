package strategy;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import entidades.Aluguel;
import entidades.Carro;
import entidades.Moto;

public class AlugarAdaptado {

	AlugarStrategy strategy;
	
	public void setStrategy(AlugarStrategy strategy) {
		this.strategy = strategy;
	}

	public Aluguel executar(Carro c, Date validade) {
		return strategy.alugar(c, validade);
	}
	
	public Aluguel alugarMoto(Moto m, Date validade) {
		        // MOTO
				Date hoje = new Date();
				
				// conversao de data para pegar diferenca de dias
				long diff = hoje.getTime() - validade.getTime(); 
				long diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
				
				double preco = diffDays * 20; // preco por dias
				
				//Aluguel a = new Aluguel(m, hoje, validade, preco);
				return null;
	}
}
