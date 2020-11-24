package factory;

import entidades.Anuncio;
import entidades.Veiculo;
import obs.Observador;

import java.util.List;

public class FabricaAnuncioCarroPopular extends FabricaAbstrataAnuncio{
    @Override
    public Anuncio criaAnuncio(Veiculo veiculo, List<Observador> usuariosObservadores) {
        Anuncio anuncio = new Anuncio();
        anuncio.addObservador(usuariosObservadores);
        anuncio.setVeiculo(veiculo);
        anuncio.setAlugado(false);
        anuncio.setTaxaPadrao(0.25); // 25%
        anuncio.setTipo("POPULAR");
        
        System.out.println("Carro popular anunciado com sucesso!");
        return anuncio;
    }
}
