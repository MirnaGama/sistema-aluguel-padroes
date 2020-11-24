package repositorio;

import entidades.Aluguel;
import entidades.Usuario;

import java.text.SimpleDateFormat;
import java.util.List;

public class AluguelRepositorio {

    public Usuario novoAluguel(Usuario usuario, Aluguel aluguel){
        List<Aluguel> alugueis = usuario.getLocacoes();
        alugueis.add(aluguel);
        System.out.println("Aluguel inserido com sucesso!!");
        return usuario;
    }

    public void listarAlugueis(Usuario usuario) {
        System.out.println("-------------ALUGUEIS----------------");
        if (usuario.getLocacoes().isEmpty()) {
            System.out.println("Nao existe veiculo alugado para este usuario ");
        } else {
        	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        	
            for (Aluguel aluguel : usuario.getLocacoes()) {
                System.out.println("Veiculo: " + " " + aluguel.getVeiculo().getModelo() + " " + aluguel.getVeiculo().getAno() + " " + aluguel.getVeiculo().getCor());
                System.out.println("Data de locacao: " + formatter.format(aluguel.getDataAluguel()));
                System.out.println("Data de entrega: " + formatter.format(aluguel.getValidade()));
                System.out.println("Tipo de veiculo: "+aluguel.getVeiculo().getTipo());
                System.out.println("Valor: R$ " + aluguel.getPreco()+"\n");
            }
        }
    }
    
}
