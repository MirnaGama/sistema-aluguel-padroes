package entidades;

public class Anuncio {

    private Veiculo veiculo;
    private boolean alugado; // se foi finalizado ou nao
    private double taxaPadrao; 
    private String tipo;

    public Anuncio() {
        super();
    }

    public Anuncio(Veiculo veiculo, boolean alugado) {
        super();
        this.veiculo = veiculo;
        this.alugado = alugado;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo v) {
        this.veiculo = v;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

	public double getTaxaPadrao() {
		return taxaPadrao;
	}

	public void setTaxaPadrao(double taxaPadrao) {
		this.taxaPadrao = taxaPadrao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
