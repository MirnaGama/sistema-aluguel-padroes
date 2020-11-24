package factory;

import entidades.Anuncio;
import entidades.Veiculo;
import obs.Observador;

import java.util.List;

public class FabricaAnuncioMoto extends FabricaAbstrataAnuncio{
    @Override
    public Anuncio criaAnuncio(Veiculo veiculo, List<Observador> usuariosObservadores) {
        Anuncio anuncio = new Anuncio();
        anuncio.addObservador(usuariosObservadores);
        anuncio.setVeiculo(veiculo);
        anuncio.setAlugado(false);
        anuncio.setTaxaPadrao(0.2); // 20%
        anuncio.setTipo("MOTO");
        
        System.out.println("Moto anunciada com sucesso!");
        return anuncio;
    }
}
