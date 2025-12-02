package exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.Employee2;
import entities.OutsourcedEmployee;

public class ExercicioEmployee {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	
		List<Employee2> list = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int numberOfEmployees = sc.nextInt();
		
	
		for (int i=0; i<numberOfEmployees; i++) {
			System.out.println("Employee #" + (i+1) + " data:");
			
			System.out.print("Outsourced (y/n): ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			if(ch == 'y') {
				
				System.out.print("Additional charge:");
				double additionalCharge = sc.nextDouble();
				Employee2 emp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
			
				list.add(emp);
				
			} else {
				
				Employee2 emp = new Employee2(name, hours, valuePerHour);
				
				list.add(emp);
			}
			
		}
		
		System.out.println();
		System.out.println("PAYMENTS:");
		
		for (Employee2 emp : list) {
			System.out.println(emp.getName() + " - $" + emp.payment());
		}
		
		
		sc.close();
	
	}

}
