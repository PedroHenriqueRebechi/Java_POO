package model.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.Contract;
import entities.Installment;

public class ContractService {
		
	private OnlinePaymentService onlinePaymentService;
	
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public OnlinePaymentService getOnlinePaymentService() {
		return onlinePaymentService;
	}

	public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		
		List<Installment> installments = new ArrayList<>();
		
		for (int i=0; i<months; i++) {
			
			LocalDate dueDate = contract.getDate().plusMonths(i+1);
			
			double amount = contract.getTotalValue() / months;	
			double interestValue = getOnlinePaymentService().interest(amount, i+1);
			double paymentFeeValue = getOnlinePaymentService().paymentFee(interestValue);
			
			Installment installment = new Installment(dueDate, paymentFeeValue);
			installments.add(installment);
		}
		
		contract.setInstallments(installments);
	}
}
