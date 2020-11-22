package repositorio;

import entidades.Aluguel;
import entidades.Usuario;

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
            System.out.println("Não existe veículos alugados para este usuário ");
        } else {
            for (Aluguel aluguel : usuario.getLocacoes()) {
                System.out.println(" Veículo: " + " " + aluguel.getVeiculo().getModelo() + " " + aluguel.getVeiculo().getAno() + " " + aluguel.getVeiculo().getCor());
                System.out.println("Data de locação: " + aluguel.getDataAluguel());
                System.out.println("Data de entrega: " + aluguel.getValidade());
                System.out.println("Valor: R$ " + aluguel.getPreco());
            }
        }
    }
    
}
