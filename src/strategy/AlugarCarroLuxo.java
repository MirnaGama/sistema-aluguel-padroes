package strategy;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import entidades.Aluguel;
import entidades.Carro;
import entidades.Usuario;

public class AlugarCarroLuxo implements AlugarStrategy {

	@Override
	public Aluguel alugar(Carro c, int dias, double taxa) {
		System.out.println("Alugando carro de luxo ...");
		// CARRO DE LUXO (60 REAIS POR DIA + TAXA)
		Date hoje = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(hoje);
		cal.add(Calendar.DATE, dias);
		Date validade = cal.getTime();
		
		double preco = (dias * 60);
		preco += preco * taxa;// preco por dias + taxa
		
		Aluguel a = new Aluguel(c, hoje, validade, preco);
		return a;
	}


}
