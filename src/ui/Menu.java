package ui;

import java.util.Scanner;

import entidades.Usuario;
import repositorio.UsuarioRepositorio;

public class Menu {
	
	private static UsuarioRepositorio usuarioRep = new UsuarioRepositorio();
	static Scanner sc = new Scanner(System.in);
	
public static void main(String[] args) {
	while (true) {
	System.out.println("1) Cadastrar Usuário \n2) Login");
	
	int escolha = sc.nextInt();
	
	switch (escolha) {
	case 1:
		cadastrarUsuario();
	case 2:
		login();
	}
	}
}	

public static void login() {
	System.out.println("Digite seu cpf: ");
	String cpf = sc.next();
	
	Usuario u = usuarioRep.procurarPorCpf(cpf);
	if (u != null) {
		System.out.println("Bem-vindo "+u.getNome()+"!");
	} else {
		System.out.println("Ops! Usuário não cadastrado!");
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
		System.out.println("Ops! Usuário já cadastrado!");
	} else {
		Usuario u = new Usuario(nome, email, cpf);
		usuarioRep.inserir(u);
		System.out.println("Usuário "+u.getNome()+" cadastrado com sucesso! :)");
	}

}

}
