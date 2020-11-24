package strategy;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import entidades.Aluguel;
import entidades.Moto;

public class AlugarMoto {

	public Aluguel alugarMoto(Moto m, int dias, double taxa) {
		System.out.println("Alugando moto ...");
		
		Date hoje = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(hoje);
		cal.add(Calendar.DATE, dias);
		Date validade = cal.getTime();
		
		double preco = (dias * 20);
		preco += preco * taxa;// preco por dias + taxa
		
		Aluguel a = new Aluguel(m, hoje, validade, preco);
		return a;
}
}
