package ui;

import java.util.*;

import entidades.*;
import repositorio.AluguelRepositorio;
import repositorio.UsuarioRepositorio;
import strategy.AlugarAdaptado;
import strategy.AlugarStrategy;

public class Menu {

	private static UsuarioRepositorio usuarioRep = new UsuarioRepositorio();
	private static AluguelRepositorio alugueisRep = new AluguelRepositorio();
	private static List<Anuncio> anuncios = popularAnuncios();
	private static AlugarStrategy strategy;
	private static AlugarAdaptado alugarAdaptado = new AlugarAdaptado(strategy);

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		while (true) {
			System.out.println("BEM VINDO AO ALUGUECAR!! ");
			System.out.println("1) Cadastrar Usu�rio \n2) Login");

			int escolha = sc.nextInt();

			switch (escolha) {
			case 1:
				cadastrarUsuario();
				break;
			case 2:
				login();
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
			while (sair){
				System.out.println("Bem-vindo " + u.getNome() + "!");
				System.out.println("Digite a opção que deseja: ");
				System.out.println("1) Visualizar anúncios e alugar um veículo");
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
			System.out.println("Ops! Usu�rio n�o cadastrado!");
		}

	}

	private static void visualizarAnuncios(Usuario usuario) {
		System.out.println("-------------ANÚNCIOS----------------");
			for (Anuncio anuncio : anuncios) {
				if(!anuncio.isAlugado()){
					System.out.println(" Veículo: " + anuncio.getCarro().getFabricante() + " "  + anuncio.getCarro().getModelo() + " " +anuncio.getCarro().getAno() + " " + anuncio.getCarro().getCor());
					System.out.println("Deseja alugar este veículo ?");
					String alugar = sc.next();
					if(alugar.equals("sim")){
						System.out.println("Quantos dias você deseja passar com o veículo ?");
						int dias = sc.nextInt();
						Date hoje = new Date();
						hoje.setTime(hoje.getTime() + dias);
						Aluguel aluguel = alugarAdaptado.alugar(anuncio.getCarro(), hoje);
						System.out.println("Confirma o aluguel do veículo por R$ " + aluguel.getPreco());
						String confirma = sc.next();
						if (confirma.equals("sim")){
							alugueisRep.novoAluguel(usuario, aluguel);
							anuncio.setAlugado(true);
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
			System.out.println("Ops! Usu�rio j� cadastrado!");
		} else {
			Usuario u = new Usuario(nome, email, cpf);
			usuarioRep.inserir(u);
			System.out.println("Usu�rio " + u.getNome() + " cadastrado com sucesso! :)");
		}

	}

	private static List<Anuncio> popularAnuncios() {
		List<Anuncio> anuncios = new ArrayList<>();

		//SANDERO
		Anuncio anuncioSandero = new Anuncio();
		CarroPopular sandero = new CarroPopular("renault", "sandero", 2016, "branco");
		anuncioSandero.setCarro(sandero);
		anuncioSandero.setAlugado(false);
		anuncios.add(anuncioSandero);

		//GOL
		Anuncio anuncioGol = new Anuncio();
		CarroPopular gol = new CarroPopular("volkswagen", "gol", 2019, "preto");
		anuncioSandero.setCarro(gol);
		anuncioSandero.setAlugado(false);
		anuncios.add(anuncioGol);

		//ONIX
		Anuncio anuncioOnix = new Anuncio();
		CarroPopular onix = new CarroPopular("chevrolet", "onix", 2018, "prata");
		anuncioSandero.setCarro(onix);
		anuncioSandero.setAlugado(false);
		anuncios.add(anuncioOnix);

		//FORD Ka
		Anuncio anuncioKa = new Anuncio();
		CarroPopular ka = new CarroPopular("ford", "ka", 2020, "vermelho");
		anuncioSandero.setCarro(ka);
		anuncioSandero.setAlugado(false);
		anuncios.add(anuncioKa);

		//Mercedes
		Anuncio anuncioMercedes = new Anuncio();
		CarroLuxo gla = new CarroLuxo("Mercedes", "GLA", 2020, "cinza");
		anuncioSandero.setCarro(gla);
		anuncioSandero.setAlugado(false);
		anuncios.add(anuncioMercedes);

		//BMW
		Anuncio anuncioBMW = new Anuncio();
		CarroLuxo bmw = new CarroLuxo("BMW", "X1", 2020, "preto");
		anuncioSandero.setCarro(bmw);
		anuncioSandero.setAlugado(false);
		anuncios.add(anuncioBMW);

		//SW4
		Anuncio anuncioSw4 = new Anuncio();
		CarroLuxo sw4 = new CarroLuxo("Toyota", "SW4", 2020, "branco");
		anuncioSandero.setCarro(sw4);
		anuncioSandero.setAlugado(false);
		anuncios.add(anuncioSw4);
		return anuncios;
	}



}
