package factory;

import entidades.Anuncio;
import entidades.Veiculo;
import obs.Observador;

import java.util.List;

public class FabricaAnuncioCarroLuxo extends FabricaAbstrataAnuncio{
    @Override
    public Anuncio criaAnuncio(Veiculo veiculo, List<Observador> usuariosObservadores) {
        Anuncio anuncio = new Anuncio();
        anuncio.addObservador(usuariosObservadores);
        anuncio.setVeiculo(veiculo);
        anuncio.setAlugado(false);
        anuncio.setTaxaPadrao(0.4); // 40%
        anuncio.setTipo("LUXO");
        
        System.out.println("Carro de luxo anunciado com sucesso!");
        return anuncio;
    }
}
