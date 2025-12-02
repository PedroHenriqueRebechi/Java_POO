package exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class ExercicioProduct {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of products: ");
		int numberOfProducts = sc.nextInt();
		
		List<Product> products = new ArrayList<>();
		
		for (int i=0; i<numberOfProducts; i++) {
			
			System.out.println("Product #" + (i+1) + " data:");
			
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			sc.nextLine();
			
			if (type == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				
				products.add(new ImportedProduct(name, price, customsFee));
				
			} else if (type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String manufactureDate = sc.nextLine();
				
				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate manufactureDateFormatted = LocalDate.parse(manufactureDate, fmt);
				
				products.add(new UsedProduct(name, price, manufactureDateFormatted));
				
			} else {
				
				products.add(new Product(name, price));
			}
			
		}
		
		System.out.println("PRICE TAGS:");
		
		for (Product p : products) {
			System.out.println(p.getName() + " " + p.priceTag());
		}
	}

}
