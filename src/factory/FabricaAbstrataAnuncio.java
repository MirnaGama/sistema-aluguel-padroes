package factory;

import entidades.Anuncio;
import entidades.Veiculo;
import obs.Observador;

import java.util.List;

public abstract class FabricaAbstrataAnuncio {

    public abstract Anuncio criaAnuncio(Veiculo veiculo, List<Observador> usuariosObservadores);
}
