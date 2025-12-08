package exercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExercicioFileReader {

	public static void main(String[] args) {

		String path = "c:\\temp\\arquivo.txt";
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
