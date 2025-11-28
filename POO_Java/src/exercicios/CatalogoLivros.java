package exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Livro;

public class CatalogoLivros {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		List<Livro> catalogo = new ArrayList<>();
		
		System.out.print("Quantos livros você quer adicionar: ");
		int quantidade = sc.nextInt();
		sc.nextLine();
		
		for (int i=0; i<quantidade; i++) {
			System.out.print("Título do livro: ");
			String titulo = sc.nextLine().trim();
			
			System.out.print("Ano de publicação: ");
			Integer anoPublicacao = sc.nextInt();
			sc.nextLine();
			
			catalogo.add(new Livro(titulo, anoPublicacao));
		}
		
		System.out.print("Digite o título do livro a ser removido: ");
		String livroRemover = sc.nextLine().trim();
		
		catalogo.removeIf(livro -> livroRemover.equals(livro.getTitulo()));
		
		for (Livro livro : catalogo) {
			System.out.println(livro.toString());
		}
	}

}
