package entidades;

import java.util.ArrayList;
import java.util.List;

import obs.Observado;
import obs.Observador;

public class Anuncio implements Observado {

	public List<Observador> observadores;
    private Veiculo veiculo;
    private boolean alugado; // se foi finalizado ou nao
    private double taxaPadrao; 
    private String tipo;

    public Anuncio() {
        super();
        this.observadores = new ArrayList<>();
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
        notificar();
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

	@Override
	public void addObservador(List<Observador> o) {
		for (Observador observador : o) {
            this.observadores.add(observador);
        }
	}

	@Override
	public void removerObservador(Observador o) {
		 int index = this.observadores.indexOf(o);
	        if (index > -1) {
	            this.observadores.remove(o);
	        }	
	}

	@Override
	public void notificar() {
		for (Observador observador : this.observadores) {
            observador.notificarAnuncio(this.getVeiculo());
        }
	}

}
