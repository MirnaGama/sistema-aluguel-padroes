package strategy;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import entidades.Aluguel;
import entidades.Carro;
import entidades.Moto;

public class AlugarAdaptado extends AlugarContext {

	private AlugarMoto alugar;
	
	public AlugarAdaptado(AlugarStrategy strategy) {
		super(strategy);
	}
	
	// PREMISSA -- TUDO RELACIONADO AO STRATEGY FOI RESTRITO, logo é necessario outro método para poder alugar uma moto
	public Aluguel alugarMoto(Moto m, Date validade) {
		      return alugar.alugarMoto(m, validade);
	}
}
