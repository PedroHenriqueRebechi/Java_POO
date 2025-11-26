package exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class EmployeeRaise {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered?");
		int numberOfEmployeesToRegister = sc.nextInt();		
		
		List<Employee> employees = new ArrayList<>();
		
		
		for (int i = 0; i < numberOfEmployeesToRegister; i++) {
			System.out.printf("Employee #%d%n", i + 1);
			
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine().trim();
			
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			employees.add(new Employee(id, name, salary));
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		Integer employeeId = sc.nextInt();
		
		List<Employee> result = employees.stream()
			.filter(x -> x.getId().equals(employeeId))
			.collect(Collectors.toList());
		
		if(result.isEmpty()) {

			System.out.println("This id does not exist!");
			
		} else {
			
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			
			for (Employee x : employees) {
				if (x.getId() == employeeId) {
					x.increaseSalary(percentage);
				}
			}
		}
		
		
		System.out.printf("%nList of employees:%n");
		
		employees.stream().sorted(java.util.Comparator.comparingInt(Employee::getId))
			.forEach(x ->
				System.out.printf(
					"%d, %s, %.2f%n",
					x.getId(),
					x.getName(),
					x.getSalary()
				)
			);
	}
		
}

