package ui;

import java.util.Scanner;

public class UsuarioUI {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	Menu m = new Menu(sc);
	
	m.menuInicial();
}
}
