package exercicios;

import java.io.File;
import java.util.Scanner;

public class InformacoesPath {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a file path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		// Nome do arquivo
		System.out.println("getName: " + path.getName());
		
		// Só o caminho
		System.out.println("getParent: " + path.getParent());

		// Caminho completo
		System.out.println("getPath: " + path.getPath());

		
		sc.close();
	}

}
