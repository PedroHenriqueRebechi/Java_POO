package exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class ExercicioImpostoDeRenda {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		System.out.print("Digite o número de devedores: ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			
			System.out.println("Devedor #" + (i+1) + " data:");
			
			System.out.print("Pessoa física ou jurídica (f/j)? ");
			char tipo = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Renda anual: ");
			double rendaAnual = sc.nextDouble();
			
			if (tipo == 'f') {
				System.out.print("Gastos com saúde: ");
				double gastosComSaude = sc.nextDouble();
				
				pessoas.add(new PessoaFisica(name, rendaAnual, gastosComSaude));
			} else {
				System.out.print("Número de funcionários: ");
				int numeroDeFuncionarios = sc.nextInt();
				
				pessoas.add(new PessoaJuridica(name, rendaAnual, numeroDeFuncionarios));
			}
			
		}
		
		System.out.println("Taxas pagas: ");
		
		double soma = 0;
		
		for (Pessoa p : pessoas) {
			System.out.println(p.getNome() + ": $ " + String.format("%.2f", p.calcularImpostoDeRenda()));
			soma += p.calcularImpostoDeRenda();
		}
		
		System.out.print("Total: $ " + String.format("%.2f", soma));
	}

}
