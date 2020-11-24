package factory;

import entidades.Anuncio;
import entidades.Veiculo;

public class FabricaAnuncioCarroPopular extends FabricaAbstrataAnuncio{
    @Override
    public Anuncio criaAnuncio(Veiculo veiculo) {
        Anuncio anuncio = new Anuncio();
        anuncio.setVeiculo(veiculo);
        anuncio.setAlugado(false);
        anuncio.setTaxaPadrao(0.25); // 25%
        anuncio.setTipo("POPULAR");
        
        System.out.println("Carro popular anunciado com sucesso!");
        return anuncio;
    }
}
