package factory;

import entidades.Anuncio;
import entidades.Veiculo;

public abstract class FabricaAbstrataAnuncio {

    public abstract Anuncio criaAnuncio(Veiculo veiculo);
}
