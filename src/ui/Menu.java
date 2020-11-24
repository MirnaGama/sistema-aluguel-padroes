package ui;

import java.util.*;

import entidades.*;
import repositorio.*;
import strategy.*;

public class Menu {

    private static UsuarioRepositorio usuarioRep = new UsuarioRepositorio();
    private static AluguelRepositorio alugueisRep = new AluguelRepositorio();
    private static List<Observador> usuariosObservadores;
    private static List<Anuncio> anuncios;
    private static AlugarAdaptado alugarAdaptado;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        usuariosObservadores = popularUsuarios();
        anuncios = popularAnuncios();
        boolean sair = true;
        while (sair) {
            System.out.println("BEM VINDO AO ALUGUECAR!! ");
            System.out.println("1) Cadastrar Usuario \n2) Login \n3)Sair");

            int escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    login();
                    break;
                default:
                    sair = false;
                    break;
            }
        }
    }

    public static void login() {
        System.out.println("Digite seu cpf: ");
        String cpf = sc.next();
        boolean sair = true;
        Usuario u = usuarioRep.procurarPorCpf(cpf);

        if (u != null) {
            while (sair) {
                System.out.println("Bem-vindo " + u.getNome() + "!");
                System.out.println("Digite a opcao que deseja: ");
                System.out.println("1) Visualizar anuncios e alugar um veiculo");
                System.out.println("2) Listar alugueis ");
                System.out.println("3) Listar notificações ");
                System.out.println("4) Parar de receber novos anuncios ");
                System.out.println("5) Sair ");
                int escolha = sc.nextInt();
                switch (escolha) {
                    case 1:
                        visualizarAnuncios(u);
                        break;
                    case 2:
                        alugueisRep.listarAlugueis(u);
                        break;
                    case 3:
                        u.listarNotificacoes();
                        break;
                    case 4:
                        usuariosObservadores.remove(u);
                        System.out.println("\nPronto! Você não receberá mais nenhum anuncio.\n");
                        break;
                    case 5:
                        sair = false;
                        break;
                }
            }
        } else {
            System.out.println("Ops! Usuario nao cadastrado!");
        }

    }

    private static void visualizarAnuncios(Usuario usuario) {
        Anuncio anuncioSandero = new Anuncio();
        Veiculo sandero = new CarroPopular("renault", "sandero", 2016, "branco");

        System.out.println("-------------ANUNCIOS----------------");

        for (Anuncio anuncio : anuncios) {
            if (!anuncio.isAlugado()) {
                System.out.println(" Veiculo: " + anuncio.getVeiculo().getFabricante() + " " + anuncio.getVeiculo().getModelo() + " " + anuncio.getVeiculo().getAno() + " " + anuncio.getVeiculo().getCor());
                System.out.println("Deseja alugar este veiculo ?");
                String alugar = sc.next();
                if (alugar.equals("sim")) {

                    String tipoAnuncio = anuncio.getVeiculo().getTipo();
                    if (tipoAnuncio.equalsIgnoreCase("LUXO")) {
                        alugarAdaptado = new AlugarAdaptado(new AlugarCarroLuxo());
                    } else if (tipoAnuncio.equalsIgnoreCase("POPULAR")) {
                        alugarAdaptado = new AlugarAdaptado(new AlugarCarroPopular());
                    }


                    System.out.println("Quantos dias voce deseja passar com o veiculo ?");
                    int dias = sc.nextInt();

                    // SE O ANUNCIO FOR DE CARRO
                    if (anuncio.getVeiculo() instanceof Carro) {
                        Carro carroAnuncio = (Carro) anuncio.getVeiculo();

                        Aluguel aluguel = alugarAdaptado.alugar(carroAnuncio, dias);
                        System.out.println("Confirma o aluguel do veiculo por R$ " + aluguel.getPreco());
                        String confirma = sc.next();
                        if (confirma.equals("sim")) {
                            alugueisRep.novoAluguel(usuario, aluguel);
                            anuncio.setAlugado(true);
                        }
                    }

                }
            }
        }
    }

    public static void cadastrarUsuario() {
        System.out.println("Digite seu nome: ");
        String nome = sc.next();
        System.out.println("Digite seu email: ");
        String email = sc.next();
        System.out.println("Digite seu cpf: ");
        String cpf = sc.next();

        if (usuarioRep.procurarPorCpf(cpf) != null) {
            System.out.println("Ops! Usuario ja cadastrado!");
        } else {
            Usuario u = new Usuario(nome, email, cpf);
            usuarioRep.inserir(u);
            usuariosObservadores.add(u);
            System.out.println("Usuario " + u.getNome() + " cadastrado com sucesso! :)");
        }

    }

    private static List<Anuncio> popularAnuncios() {
        List<Anuncio> anuncios = new ArrayList<>();

        //SANDERO
        Anuncio anuncioSandero = new Anuncio();
        anuncioSandero.addObservador(usuariosObservadores);
        Veiculo sandero = new CarroPopular("renault", "sandero", 2016, "branco");
        anuncioSandero.setVeiculo(sandero);
        anuncioSandero.setAlugado(false);
        anuncios.add(anuncioSandero);

        //GOL
        Anuncio anuncioGol = new Anuncio();
        anuncioGol.addObservador(usuariosObservadores);
        Veiculo gol = new CarroPopular("volkswagen", "gol", 2019, "preto");
        anuncioGol.setVeiculo(gol);
        anuncioGol.setAlugado(false);
        anuncios.add(anuncioGol);

        //ONIX
        Anuncio anuncioOnix = new Anuncio();
        anuncioOnix.addObservador(usuariosObservadores);
        Veiculo onix = new CarroPopular("chevrolet", "onix", 2018, "prata");
        anuncioOnix.setVeiculo(onix);
        anuncioOnix.setAlugado(false);
        anuncios.add(anuncioOnix);

        //FORD Ka
        Anuncio anuncioKa = new Anuncio();
        anuncioKa.addObservador(usuariosObservadores);
        Veiculo ka = new CarroPopular("ford", "ka", 2020, "vermelho");
        anuncioKa.setVeiculo(ka);
        anuncioKa.setAlugado(false);
        anuncios.add(anuncioKa);

        //Mercedes
        Anuncio anuncioMercedes = new Anuncio();
        anuncioMercedes.addObservador(usuariosObservadores);
        Veiculo gla = new CarroLuxo("Mercedes", "GLA", 2020, "cinza");
        anuncioMercedes.setVeiculo(gla);
        anuncioMercedes.setAlugado(false);
        anuncios.add(anuncioMercedes);

        //BMW
        Anuncio anuncioBMW = new Anuncio();
        anuncioBMW.addObservador(usuariosObservadores);
        Veiculo bmw = new CarroLuxo("BMW", "X1", 2020, "preto");
        anuncioBMW.setVeiculo(bmw);
        anuncioBMW.setAlugado(false);
        anuncios.add(anuncioBMW);

        //SW4
        Anuncio anuncioSw4 = new Anuncio();
        anuncioSw4.addObservador(usuariosObservadores);
        Veiculo sw4 = new CarroLuxo("Toyota", "SW4", 2020, "branco");
        anuncioSw4.setVeiculo(sw4);
        anuncioSw4.setAlugado(false);
        anuncios.add(anuncioSw4);
        return anuncios;
    }

	private static List<Observador> popularUsuarios() {
        List<Observador> usuariosObservadores = new ArrayList<>();

        Usuario amanda = new Usuario("Amanda", "amanda@gmail.com", "123456789");
        usuarioRep.inserir(amanda);
        usuariosObservadores.add(amanda);

        Usuario maria = new Usuario("Maria", "mariazinha@gmail.com", "123");
        usuarioRep.inserir(maria);
        usuariosObservadores.add(maria);

        Usuario joao = new Usuario("João", "joao@gmail.com", "12345");
        usuarioRep.inserir(joao);
        usuariosObservadores.add(joao);

        return usuariosObservadores;
	}
}
