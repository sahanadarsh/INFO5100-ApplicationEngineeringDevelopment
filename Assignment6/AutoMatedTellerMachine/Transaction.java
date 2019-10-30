package AutoMatedTellerMachine;

public class Transaction {
	String tName;
	double amount;
	double balance;

	public Transaction(String tName, double amount, double balance) {
		this.tName = tName;
		this.amount = amount;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
