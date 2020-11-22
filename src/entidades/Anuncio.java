package entidades;

public class Anuncio {

    private Carro carro;
    private boolean alugado; // se foi finalizado ou nao

    public Anuncio() {
        super();
    }

    public Anuncio(Carro carro, boolean alugado) {
        super();
        this.carro = carro;
        this.alugado = alugado;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }


}
