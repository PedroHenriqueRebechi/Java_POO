package exercicios;

import java.util.Locale;
import java.util.Scanner;

import entities.Quarto;


public class AluguelQuartos {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String nome = "";
		String email = "";
		int numero = 0;
		
		
		Quarto[] quartos = new Quarto[10];
		
		System.out.print("How many rooms will be rented? ");
		int n = sc.nextInt();
		
		for (int i = 0; i<n; i++) {
			
			System.out.printf("Rent #%d:%n", i+1);
			
			sc.nextLine();
			System.out.print("Name: ");
			nome = sc.nextLine().trim();
			
			System.out.print("Email: ");
			email = sc.nextLine().trim();
			
			System.out.print("Room number: ");
			numero = sc.nextInt();
			
			
			quartos[numero] = new Quarto(nome, email, numero);
			
		}
		
		System.out.println("Busy rooms: ");
		
		for (int i = 0; i<quartos.length; i++) {
			if (quartos[i]!= null) {
				System.out.printf("%d: %s, %s %n",
						quartos[i].getNumero(),
					    quartos[i].getNome(), 
					    quartos[i].getEmail());
			} else {
				System.out.printf("%d: desocupado%n", i);
			}
		}
		
		
		
		
		sc.close();
	}
}