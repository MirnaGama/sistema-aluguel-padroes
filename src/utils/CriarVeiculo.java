package utils;

import java.util.Scanner;

import entidades.CarroLuxo;
import entidades.CarroPopular;
import entidades.Moto;

public class CriarVeiculo {

	public static CarroLuxo retornarCarroLuxo(Scanner sc) {
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
	
	public static CarroPopular retornarCarroPopular(Scanner sc) {
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
	
	public static Moto retornarMoto(Scanner sc) {
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
