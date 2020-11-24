package obs;

import entidades.Veiculo;

public interface Observador {
    public void notificarAnuncio(Veiculo veiculo);
}
