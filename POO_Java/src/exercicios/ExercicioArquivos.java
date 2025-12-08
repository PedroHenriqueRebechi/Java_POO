package exercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ProdutoEletronico;

public class ExercicioArquivos {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<ProdutoEletronico> produtosEletronicos = new ArrayList<>();
		
		String strPath = "c:\\temp\\source.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
			
			String line = br.readLine();
			
			while (line != null) {
				
				String[] dadosProdutoEletronico = line.split(",");
				
				String name = dadosProdutoEletronico[0];
				double price = Double.parseDouble(dadosProdutoEletronico[1]);
				int quantity = Integer.parseInt(dadosProdutoEletronico[2]);
					
				ProdutoEletronico p = new ProdutoEletronico(name, price, quantity);
				produtosEletronicos.add(p);
					

				line = br.readLine();
			}
			
			
			File path = new File(strPath);
						
			boolean directory = new File(path.getParent() + "\\out").mkdir();
			
			if (directory) {
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.getParent() + "\\out\\summary.csv"))){
					
					for (ProdutoEletronico p : produtosEletronicos) {
						bw.write(p.getName() + "," + p.calculateTotal());
						bw.newLine();
					}
				
				}
				catch (IOException e) {
					System.out.println("Erro ao criar arquivo: " + e.getMessage());
				}
			}
			
			
			System.out.println("Arquivo criado");
			
		}
		catch (IOException e) {
			System.out.println("Erro na leitura do arquivo: " + e.getMessage());
		}
		
	}

}
