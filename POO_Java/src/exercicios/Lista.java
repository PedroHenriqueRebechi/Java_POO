package exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lista {
	
	public static void main(String[] args) {
		
		// Sintaxe da lista (apenas Wrapper Classes)
		List<String> nomeLista = new ArrayList<>();
		
		nomeLista.add("Maria");
		nomeLista.add("Jorge");
		nomeLista.add("João");
		nomeLista.add("José");
		nomeLista.add(1, "Roberto");
		
		System.out.println(nomeLista.size());
		
		// Remover por index
		nomeLista.remove(2);
		
		// Remover por valor
		nomeLista.remove("Roberto");
		
		// Função lambda
		nomeLista.removeIf(x -> x.charAt(0) == 'M');
		
		for (String x : nomeLista) {
			System.out.println(x);
		}
		
		System.out.println("Index of José: " + nomeLista.indexOf("José"));
		
		// Filtrar pessoas 
		List<String> result = nomeLista.stream().filter(x -> x.charAt(0) == 'J').collect(Collectors.toList());
		System.out.println("Lista de pessoas com J:" + result);

		
		// Filtrar primeira pessoa
		String name = nomeLista.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);
		System.out.println("Primeira pessoa com J:" + name);
	}
}
