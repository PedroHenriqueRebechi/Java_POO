package entities;

import java.util.ArrayList;
import java.util.List;

import entities.enums.WorkLevel;

public class Worker {
	private String name;
	private WorkLevel level;
	private Double baseSalary;
	
	// Associações
	private Department department;
	// Associação "tem-muitos" utiliza lista, que deve ser instanciada
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
	}
	
	public Worker(String name, WorkLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkLevel getLevel() {
		return level;
	}

	public void setLevel(WorkLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		
		for (HourContract c : contracts) {
			int c_year = c.getDate().getYear();
			int c_month = c.getDate().getMonthValue();
			
			if (c_year == year && c_month == month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
	
}
