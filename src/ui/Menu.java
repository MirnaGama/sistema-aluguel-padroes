package ui;

import java.util.*;

import entidades.*;
import factory.*;
import obs.Observador;
import repositorio.*;
import strategy.*;
import utils.CriarVeiculo;

public class Menu {

    private static UsuarioRepositorio usuarioRep = new UsuarioRepositorio();
    private static AluguelRepositorio alugueisRep = new AluguelRepositorio();
    private static List<Anuncio> anuncios;
    private static AlugarAdaptado alugarAdaptado = new AlugarAdaptado(null);
    private static FabricaAbstrataAnuncio fabricaAnuncio;
    
    // OBSERVER
    private static List<Observador> usuariosObservadores;

    static Scanner sc;

    public Menu(Scanner sc) {
		this.sc = sc;
	}

	public void menuInicial() {
        
        usuariosObservadores = popularUsuarios();
        anuncios = popularAnuncios();
        
        boolean sair = true;
        
        System.out.println("\nBEM VINDO AO ALUGUECAR!! ");
        
        while (sair) {
            System.out.println("\n1) Cadastrar Usuario \n2) Login \n3) Criar Anuncio \n4) Sair");

            int escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                	criarAnuncioAdmin();
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
        	System.out.println("\nBem-vindo " + u.getNome() + "!");
            while (sair) {
                System.out.println("\nDigite a opcao que deseja: ");
                System.out.println("1) Visualizar anuncios e alugar um veiculo");
                System.out.println("2) Listar alugueis ");
                System.out.println("3) Listar notificacoes ");
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
                        System.out.println("\nPronto! Voce nao recebera mais nenhum anuncio.\n");
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
        System.out.println("-------------ANUNCIOS----------------");
        for (Anuncio anuncio : anuncios) {
            if (!anuncio.isAlugado()) {
                System.out.println(" Veiculo: " + anuncio.getVeiculo().getFabricante() + " " + anuncio.getVeiculo().getModelo() + " " + anuncio.getVeiculo().getAno() + " " + anuncio.getVeiculo().getCor() + ", tipo: " + anuncio.getTipo());
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

                        Aluguel aluguel = alugarAdaptado.alugar(carroAnuncio, dias, anuncio.getTaxaPadrao());
                        System.out.println("Confirma o aluguel deste carro por R$ " + aluguel.getPreco());
                        String confirma = sc.next();
                        if (confirma.equals("sim")) {
                            alugueisRep.novoAluguel(usuario, aluguel);
                            anuncio.setAlugado(true);
                        }
                     // SE O ANUNCIO FOR DE MOTO
                    } else if (anuncio.getVeiculo() instanceof Moto) {
                    	Moto motoAnuncio = (Moto) anuncio.getVeiculo();
                    	
                    	Aluguel aluguel = alugarAdaptado.alugarMoto(motoAnuncio, dias, anuncio.getTaxaPadrao());
                    	System.out.println("Confirma o aluguel desta moto por R$ " + aluguel.getPreco());
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
        System.out.println("Digite seu cpf: ");
        String cpf = sc.next();

        if (usuarioRep.procurarPorCpf(cpf) != null) {
            System.out.println("Ops! Usuario ja cadastrado!");
        } else {
            Usuario u = new Usuario(nome, cpf);
            usuarioRep.inserir(u);
            usuariosObservadores.add(u);
            System.out.println("Usuario " + u.getNome() + " cadastrado com sucesso! :)");
        }

    }

    private static List<Anuncio> popularAnuncios() {
        List<Anuncio> anuncios = new ArrayList<>();
        Anuncio anuncio;
        // CARRO POPULAR
        fabricaAnuncio = new FabricaAnuncioCarroPopular();
        
        //SANDERO
        Veiculo sandero = new CarroPopular("renault", "sandero", 2016, "branco");
        anuncio = fabricaAnuncio.criaAnuncio(sandero, usuariosObservadores);
        anuncios.add(anuncio);

        //GOL
        Veiculo gol = new CarroPopular("volkswagen", "gol", 2019, "preto");
        anuncio = fabricaAnuncio.criaAnuncio(gol, usuariosObservadores);
        anuncios.add(anuncio);

        //ONIX
        Veiculo onix = new CarroPopular("chevrolet", "onix", 2018, "prata");
        anuncio = fabricaAnuncio.criaAnuncio(onix, usuariosObservadores);
        anuncios.add(anuncio);

        //FORD Ka
        Veiculo ka = new CarroPopular("ford", "ka", 2020, "vermelho");
        anuncio = fabricaAnuncio.criaAnuncio(ka, usuariosObservadores);
        anuncios.add(anuncio);

        // CARRO LUXO
        fabricaAnuncio = new FabricaAnuncioCarroLuxo();
        
        //Mercedes
        Veiculo gla = new CarroLuxo("Mercedes", "GLA", 2020, "cinza");
        anuncio = fabricaAnuncio.criaAnuncio(gla, usuariosObservadores);
        anuncios.add(anuncio);

        //BMW
        Veiculo bmw = new CarroLuxo("BMW", "X1", 2020, "preto");
        anuncio = fabricaAnuncio.criaAnuncio(bmw, usuariosObservadores);
        anuncios.add(anuncio);

        //SW4
        Veiculo sw4 = new CarroLuxo("Toyota", "SW4", 2020, "branco");
        anuncio = fabricaAnuncio.criaAnuncio(sw4, usuariosObservadores);
        anuncios.add(anuncio);
        
        // MOTOS
        fabricaAnuncio = new FabricaAnuncioMoto();
        Veiculo suzuki = new Moto("Suzuki", "DL650", 2014, "preta", "V-Storm", "ABS");
        anuncio = fabricaAnuncio.criaAnuncio(suzuki, usuariosObservadores);
        anuncios.add(anuncio);
        return anuncios;
    }

	private static List<Observador> popularUsuarios() {
		List<Observador> usuariosObservadores = new ArrayList<>();

        Usuario amanda = new Usuario("Amanda", "123456789");
        usuarioRep.inserir(amanda);
        usuariosObservadores.add(amanda);

        Usuario maria = new Usuario("Maria", "123");
        usuarioRep.inserir(maria);
        usuariosObservadores.add(maria);

        Usuario joao = new Usuario("Joao", "12345");
        usuarioRep.inserir(joao);
        usuariosObservadores.add(joao);
        
        return usuariosObservadores;
	}
	
	public static void criarAnuncioAdmin() {
		boolean sair = false;
		
		while (!sair) {
			
			System.out.println("\nEscolha o tipo de veiculo: \n1) Carro Popular \n2) Carro de Luxo \n3) Moto");
			int escolha = sc.nextInt();
			
			Anuncio anuncio = new Anuncio();
			
			switch (escolha) {
			
			case 1:
				fabricaAnuncio = new FabricaAnuncioCarroPopular();
				
				CarroPopular cA = CriarVeiculo.retornarCarroPopular(sc);

				anuncio = fabricaAnuncio.criaAnuncio(cA, usuariosObservadores);
				anuncios.add(anuncio);
				
				break;
				
			case 2:
			    fabricaAnuncio = new FabricaAnuncioCarroLuxo();
			    
			    CarroLuxo cL = CriarVeiculo.retornarCarroLuxo(sc);

				anuncio = fabricaAnuncio.criaAnuncio(cL, usuariosObservadores);
				anuncios.add(anuncio);
				
				break;
			
			case 3:
				fabricaAnuncio = new FabricaAnuncioMoto();
				
				Moto m = CriarVeiculo.retornarMoto(sc);

				anuncio = fabricaAnuncio.criaAnuncio(m, usuariosObservadores);
				anuncios.add(anuncio);
				
				break;
				
			}
			
			System.out.println("Deseja criar outro anuncio?");
			String resposta = sc.next();
			if (resposta.equalsIgnoreCase("nao")) {
				sair = true;
			}
		}
		
	}
	
}
