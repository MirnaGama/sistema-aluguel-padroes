package factory;

import entidades.Anuncio;
import entidades.Veiculo;

public class FabricaAnuncioCarroLuxo extends FabricaAbstrataAnuncio{
    @Override
    public Anuncio criaAnuncio(Veiculo veiculo) {
        Anuncio anuncio = new Anuncio();
        anuncio.setVeiculo(veiculo);
        anuncio.setAlugado(false);
        anuncio.setTaxaPadrao(0.4); // 40%
        anuncio.setTipo("LUXO");
        
        System.out.println("Carro de luxo anunciado com sucesso!");
        return anuncio;
    }
}
