package exercicios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import entities.Order;
import entities.enums.OrderStatus;

public class Enumeracoes {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		LocalDateTime date = LocalDateTime.parse("09/09/2020 05:20:23", fmt1);
		
		Order order = new Order(date, OrderStatus.PENDING_PAYMENT);
		
		System.out.println(order);
		
		
		OrderStatus os1 = OrderStatus.DELIVERED;
		OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

	}

}
