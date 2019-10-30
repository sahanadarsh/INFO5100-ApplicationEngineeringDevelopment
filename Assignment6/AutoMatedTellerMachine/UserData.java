package AutoMatedTellerMachine;

import java.util.LinkedList;

public class UserData {

	User userInfo;
	String password;
	boolean atmAccountCreated;
	double availableBalance;
	LinkedList<Transaction> transactionList = new LinkedList<>();

	public UserData(String name, int age, String address, String phoneNumber, String bankAccountNumber, double availableBalance) {
		this.userInfo = new User(name,age,address,phoneNumber, bankAccountNumber);
		this.availableBalance = availableBalance;
		this.atmAccountCreated = false;
	}

	public void addTransaction(Transaction t) {
		if(transactionList.size() < 10) {
			transactionList.add(t);
		}else {
			transactionList.remove();
			transactionList.add(t);
		}
	}

	public boolean isAtmAccountCreated() {
		return this.atmAccountCreated;
	}

	public void setAtmAccountCreated(boolean atmAccountCreated) {
		this.atmAccountCreated = atmAccountCreated;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public double getAvailableBalance() {
		return this.availableBalance;
	}

	public void setPassword(String password) {
		this.password = password;
		this.atmAccountCreated = true;
	}

	public String getPassword() {
		return this.password;
	}

	public void displayTransaction() {
		for(int i = transactionList.size()-1 ; i >= 0; i-- ) {
			System.out.println(transactionList.get(i).gettName() + " amount: " + transactionList.get(i).getAmount()
					+ ", remaining account balance: " + transactionList.get(i).getBalance());		
		}
	}

}
