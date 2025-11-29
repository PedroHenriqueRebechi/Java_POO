package exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkLevel;

public class Work {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double workerBaseSalary = sc.nextDouble();
		
		Department department = new Department(departmentName);
		Worker worker = new Worker(workerName, WorkLevel.valueOf(workerLevel), workerBaseSalary, department);
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i=0; i<n; i++) {
			System.out.println("Enter contract #" + (i+1) + " data");
			System.out.print("Date (DD/MM/YYYY): ");
			LocalDate contractDate = LocalDate.parse(sc.nextLine(), fmt1);
			
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			sc.nextLine();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			
			// Associando contratos com o trabalhador na lista
			worker.addContract(contract);
			
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.print("Name: " + worker.getName() + "\n");
		System.out.print("Department: " + worker.getDepartment().getName()+ "\n");
		System.out.print("Income for " + monthAndYear + ": " + worker.income(year, month));
		
		
		sc.close();
	}

}
