package entidades;

public class Anuncio {

    private Veiculo veiculo;
    private boolean alugado; // se foi finalizado ou nao

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
    


}
