package entidades;

public class Casa extends Imovel {

	private int numeroQuartos;

	
	public Casa(int numeroQuartos) {
		super();
		this.numeroQuartos = numeroQuartos;
	}

	public int getNumeroQuartos() {
		return numeroQuartos;
	}

	public void setNumeroQuartos(int numeroQuartos) {
		this.numeroQuartos = numeroQuartos;
	}
}
