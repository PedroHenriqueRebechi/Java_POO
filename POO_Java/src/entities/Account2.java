package entities;

import exceptions.AccountException;
import exceptions.NotEnoughBalanceException;

public class Account2 {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	

	public Account2(Integer number, String holder, Double balance, Double withdrawLimit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}
	
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void withdraw(double amount) {
		if (amount > withdrawLimit) {
			throw new AccountException("The amount exceeds withdraw limit");
		} else if (amount > balance) {
			throw new NotEnoughBalanceException("Not enough balance");
		} else {
			balance -= amount + 5.0;
		}
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
}
