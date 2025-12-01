package exercicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Pedidos {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		
		System.out.println("Enter the client data:");
		
		System.out.print("Name:");
		String name = sc.nextLine().trim();
		
		System.out.print("Email:");
		String email = sc.nextLine().trim();
		
		System.out.print("Birth date (DD/MM/YYYY):");
		String birthDate = sc.nextLine();
		LocalDate birthDateFormatted = LocalDate.parse(birthDate, fmt1);
		
		Client client = new Client(name, email, birthDateFormatted);
				
		System.out.println("Enter order data:");
		
		System.out.print("Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.nextLine());
		
		System.out.print("How many items to this order: ");
		int items = sc.nextInt();
		sc.nextLine();
		
		LocalDateTime now = LocalDateTime.now();
		String formattedNow = now.format(fmt2);
		LocalDateTime moment = LocalDateTime.parse(formattedNow, fmt2);
		
		Order order = new Order(moment, orderStatus, client);
		
		for (int i=0; i<items; i++) {
			System.out.println("Enter #" + (i+1) + " item data:");
			
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(quantity, product);
		
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY");
		System.out.println("Order moment: " + order.getMoment().format(fmt2));
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + order.getClient());
		System.out.println("Order items:");
		
		for (OrderItem orderItem : order.getOrderItens()) {
			System.out.println(orderItem);
		}
		
		System.out.println("Total price: $" + order.total());
	}

}
