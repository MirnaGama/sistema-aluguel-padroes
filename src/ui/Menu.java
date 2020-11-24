package ui;

import java.util.*;

import entidades.*;
import factory.*;
import repositorio.*;
import strategy.*;

public class Menu {

    private static UsuarioRepositorio usuarioRep = new UsuarioRepositorio();
    private static AluguelRepositorio alugueisRep = new AluguelRepositorio();
    private static List<Anuncio> anuncios = popularAnuncios();
    private static AlugarAdaptado alugarAdaptado;
    private static FabricaAbstrataAnuncio fabricaAnuncio;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        popularUsuarios();
        boolean sair = true;
        
        System.out.println("BEM VINDO AO ALUGUECAR!! ");
        
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
            while (sair) {
                System.out.println("Bem-vindo " + u.getNome() + "!");
                System.out.println("Digite a opcao que deseja: ");
                System.out.println("1) Visualizar anuncios e alugar um veiculo");
                System.out.println("2) Listar alugueis ");
                System.out.println("3) Sair ");
                int escolha = sc.nextInt();
                switch (escolha) {
                    case 1:
                        visualizarAnuncios(u);
                        break;
                    case 2:
                        alugueisRep.listarAlugueis(u);
                        break;
                    case 3:
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
            System.out.println("Usuario " + u.getNome() + " cadastrado com sucesso! :)");
        }

    }

    private static List<Anuncio> popularAnuncios() {
        List<Anuncio> anuncios = new ArrayList<>();
        //SANDERO
        Anuncio anuncioSandero = new Anuncio();
        Veiculo sandero = new CarroPopular("renault", "sandero", 2016, "branco");
        anuncioSandero.setVeiculo(sandero);
        anuncioSandero.setAlugado(false);
        anuncios.add(anuncioSandero);

        //GOL
        Anuncio anuncioGol = new Anuncio();
        Veiculo gol = new CarroPopular("volkswagen", "gol", 2019, "preto");
        anuncioGol.setVeiculo(gol);
        anuncioGol.setAlugado(false);
        anuncios.add(anuncioGol);

        //ONIX
        Anuncio anuncioOnix = new Anuncio();
        Veiculo onix = new CarroPopular("chevrolet", "onix", 2018, "prata");
        anuncioOnix.setVeiculo(onix);
        anuncioOnix.setAlugado(false);
        anuncios.add(anuncioOnix);

        //FORD Ka
        Anuncio anuncioKa = new Anuncio();
        Veiculo ka = new CarroPopular("ford", "ka", 2020, "vermelho");
        anuncioKa.setVeiculo(ka);
        anuncioKa.setAlugado(false);
        anuncios.add(anuncioKa);

        //Mercedes
        Anuncio anuncioMercedes = new Anuncio();
        Veiculo gla = new CarroLuxo("Mercedes", "GLA", 2020, "cinza");
        anuncioMercedes.setVeiculo(gla);
        anuncioMercedes.setAlugado(false);
        anuncios.add(anuncioMercedes);

        //BMW
        Anuncio anuncioBMW = new Anuncio();
        Veiculo bmw = new CarroLuxo("BMW", "X1", 2020, "preto");
        anuncioBMW.setVeiculo(bmw);
        anuncioBMW.setAlugado(false);
        anuncios.add(anuncioBMW);

        //SW4
        Anuncio anuncioSw4 = new Anuncio();
        Veiculo sw4 = new CarroLuxo("Toyota", "SW4", 2020, "branco");
        anuncioSw4.setVeiculo(sw4);
        anuncioSw4.setAlugado(false);
        anuncios.add(anuncioSw4);
        return anuncios;
    }

	private static void popularUsuarios() {

        Usuario amanda = new Usuario("Amanda", "123456789");
        usuarioRep.inserir(amanda);

        Usuario maria = new Usuario("Maria", "123");
        usuarioRep.inserir(maria);

        Usuario joao = new Usuario("Joao", "12345");
        usuarioRep.inserir(joao);

	}
	
	public static void criarAnuncioAdmin() {
		boolean sair = false;
		
		while (!sair) {
			
			System.out.println("\nEscolha o tipo de veículo: \n1) Carro Popular \n2) Carro de Luxo \n3) Moto");
			int escolha = sc.nextInt();
			
			Anuncio anuncio = new Anuncio();
			
			switch (escolha) {
			
			case 1:
				fabricaAnuncio = new FabricaAnuncioCarroPopular();
				
				CarroPopular cA = criarCarroPopular();
				
				anuncio = fabricaAnuncio.criaAnuncio(cA);
				anuncios.add(anuncio);
				
			case 2:
			    fabricaAnuncio = new FabricaAnuncioCarroLuxo();
			    
			    CarroLuxo cL = criarCarroLuxo();
			    
				anuncio = fabricaAnuncio.criaAnuncio(cL);
				anuncios.add(anuncio);
			
			case 3:
				fabricaAnuncio = new FabricaAnuncioMoto();
				
				Moto m = criarMoto();
				
				anuncio = fabricaAnuncio.criaAnuncio(m);
				anuncios.add(anuncio);
			}
			
			System.out.println("Deseja criar outro anuncio?");
			String resposta = sc.next();
			if (resposta.equalsIgnoreCase("nao")) {
				sair = true;
			}
		}
		
	}
	
	private static CarroLuxo criarCarroLuxo() {
		System.out.println("Digite o fabricante: ");
		String fabricante = sc.next();
		
		System.out.println("Digite o modelo: ");
		String modelo = sc.next();
		
		System.out.println("Digite o ano: ");
		int ano = sc.nextInt();
		
		System.out.println("Digite a cor: ");
		String cor = sc.next();
		
		CarroLuxo c = new CarroLuxo(fabricante, modelo, ano, cor);
		return c;
	}
	
	private static CarroPopular criarCarroPopular() {
		System.out.println("Digite o fabricante: ");
		String fabricante = sc.next();
		
		System.out.println("Digite o modelo: ");
		String modelo = sc.next();
		
		System.out.println("Digite o ano: ");
		int ano = sc.nextInt();
		
		System.out.println("Digite a cor: ");
		String cor = sc.next();
		
		CarroPopular c = new CarroPopular(fabricante, modelo, ano, cor);
		return c;
	}
	
	private static Moto criarMoto() {
		System.out.println("Digite o fabricante: ");
		String fabricante = sc.next();
		
		System.out.println("Digite o modelo: ");
		String modelo = sc.next();
		
		System.out.println("Digite o ano: ");
		int ano = sc.nextInt();
		
		System.out.println("Digite a cor: ");
		String cor = sc.next();
		
		System.out.println("Digite a categoria: ");
		String categoria = sc.next();
		
		System.out.println("Digite a versao: ");
		String versao = sc.next();
		
		Moto m = new Moto(fabricante, modelo, ano, cor, categoria, versao);
		return m;
	}


}
