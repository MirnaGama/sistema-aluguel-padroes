package entidades;

import java.util.ArrayList;
import java.util.List;

public class Anuncio implements Observado {
    private List<Observador> observadores;
    private Veiculo veiculo;
    private boolean alugado; // se foi finalizado ou nao

    public Anuncio() {
        super();
        this.observadores = new ArrayList<Observador>();
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

    @Override
    public void addObservador(List<Observador> o) {
        for (Observador observador : o) {
            observadores.add(observador);
        }
    }

    @Override
    public void removerObservador(Observador o) {
        int index = observadores.indexOf(o);
        if (index > -1) {
            observadores.remove(o);
        }
    }

    @Override
    public void notificar() {
        for (Observador o : observadores) {
            o.notificarAnuncio(this.getVeiculo());
        }
    }
}
