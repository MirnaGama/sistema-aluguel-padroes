package entidades;

public class FabricaAnuncioCarroLuxo extends FabricaAnuncio{
    @Override
    public Anuncio criaAnuncio(Veiculo veiculo) {
        Anuncio anuncio = new Anuncio();
        anuncio.setVeiculo(veiculo);
        anuncio.setAlugado(false);
        return anuncio;
    }
}
