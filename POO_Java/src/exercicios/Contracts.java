package exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Contracts {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Data (dd/mm/yyyy): ");
		String strDate = sc.nextLine().trim();
		LocalDate date = LocalDate.parse(strDate, fmt);
		
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Entre com o numero de parcelas: ");
		int months = sc.nextInt();
		
		ContractService service = new ContractService(new PaypalService());
		service.processContract(contract, months);
		
		System.out.println("Parcelas:");
		
		for (Installment inst : contract.getInstallments()) {
								
			System.out.println(inst.getDueDate().format(fmt) + " - R$" + inst.getAmount());
		}
	}

}
