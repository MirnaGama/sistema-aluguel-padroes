package entidades;

public class CarroLuxo extends Carro {
	
	public CarroLuxo(String fabricante, String modelo, int ano, String cor) {
		super(fabricante, modelo, ano, cor);
		
		this.setTipo("LUXO");
	}

}
