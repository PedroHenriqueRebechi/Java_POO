package exercicios;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Account2;
import exceptions.AccountException;
import exceptions.NotEnoughBalanceException;

public class ExercicioExcecoes {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try { 
			System.out.println("Enter account data");
			
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Holder: ");
			String holder = sc.nextLine();
	
			System.out.print("Inital balance: ");
			double initialBalance = sc.nextDouble();
			
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account2 acc = new Account2(number, holder, initialBalance, withdrawLimit);
			
			
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			
			acc.withdraw(amount);
			
			System.out.println("New balance: "+ acc.getBalance());
		}
		catch (AccountException e){
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (NotEnoughBalanceException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Verifique os dados inseridos");
		}
		
		
		System.out.println("--finalizado--");
		
		sc.close();
	}

}
