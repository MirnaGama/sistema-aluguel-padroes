package factory;

import entidades.Anuncio;
import entidades.Veiculo;

public class FabricaAnuncioMoto extends FabricaAbstrataAnuncio{
    @Override
    public Anuncio criaAnuncio(Veiculo veiculo) {
        Anuncio anuncio = new Anuncio();
        anuncio.setVeiculo(veiculo);
        anuncio.setAlugado(false);
        anuncio.setTaxaPadrao(0.2); // 20%
        anuncio.setTipo("MOTO");
        
        System.out.println("Moto anunciada com sucesso!");
        return anuncio;
    }
}
