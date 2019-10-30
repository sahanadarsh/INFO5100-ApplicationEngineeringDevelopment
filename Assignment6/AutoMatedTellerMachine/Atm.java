package AutoMatedTellerMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Atm {

	double availableAmountInMachine;
	double transactionFee;
	HashMap<String, UserData> customers = new HashMap<>();

	public Atm(double availableAmountInMachine, double transactionFee, ArrayList<UserData> list) {
		this.availableAmountInMachine = availableAmountInMachine;
		this.transactionFee = transactionFee;
		for(UserData u : list) {
			customers.put(u.userInfo.getBankAccountNumber(), u);
		}
	}

	public void start() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("Select one of the following option: ");
			System.out.println("1. NEW USER");
			System.out.println("2. CURRENT USER");
			String option = s.nextLine();
			if(option.equals("1")) {
				System.out.println("Enter account number: ");
				String accNum = s.nextLine();
				UserData ud = customers.get(accNum);
				if(ud != null) {
					System.out.println("Set Password");
					String pwd = s.nextLine();
					ud.setPassword(pwd);
				}else {
					System.out.println("Incorrect Account Number, Try again");
				}	
			}else if(option.equals("2")) {
				System.out.println("Enter account number: ");
				String accNum = s.nextLine();
				UserData ud = customers.get(accNum);
				if(ud != null) {
					if (!ud.isAtmAccountCreated()) {
						System.out.println("ATM account not created. Create NEW Atm account");
					} else {
						System.out.println("1. Enter Password");
						System.out.println("2. Forgot Password");
						option = s.nextLine();
						if(option.equals("1")) {
							int retryCount = 3;
							while(retryCount > 0) {
								String pwd = s.nextLine();
								if(pwd.equals(ud.getPassword())) {
									atmUserOpeartions(ud);
									flag = false; 
									break;
								}else {
									System.out.println("Incorrect password, Try again"); 
								}
								retryCount--;
							}
						}
						if(option.equals("2")) {
							int retryCount = 3;
							while(retryCount > 0) {
								System.out.println("Enter name");
								String name = s.nextLine();
								System.out.println("Enter age");
								String age = s.nextLine();
								System.out.println("Enter phoneNumber");
								String phoneNumber = s.nextLine();
								if(name.equals(ud.userInfo.getName()) && age.equals(String.valueOf(ud.userInfo.getAge())) && 
										phoneNumber.equals(ud.userInfo.getPhoneNumber())){
									System.out.println("Reset Password");
									String pwd = s.nextLine();
									ud.setPassword(pwd);
									break;
								}else {
									System.out.println("Incorrect deatils, try again"); 
								}
								retryCount--;
							}
						}
					}
				}else {
					System.out.println("Incorrect Account Number, Try again");
				}
			}
		}
	}

	public void atmUserOpeartions(UserData ud) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Select one of the following option: ");
			System.out.println("1. AVAILABLE BALANCE");
			System.out.println("2. WITHDRAW");
			System.out.println("3. DEPOSIT");
			System.out.println("4. RECENT TRANSACTIONS");
			System.out.println("5. CHANGE PASSWORD");
			System.out.println("6. EXIT");
			String line = scan.nextLine();

			if (line.equals("1")) {
				System.out.println(ud.getAvailableBalance());
			}

			if (line.equals("2")) {
				System.out.println("Enter amount to be withdrawn");
				double amount = Math.abs(Double.valueOf(scan.nextLine()));
				if(amount <= this.availableAmountInMachine ) {
					if(amount <= (ud.getAvailableBalance() - this.transactionFee)) {
						System.out.println("please take your cash");
						this.availableAmountInMachine = this.availableAmountInMachine - amount;
						ud.setAvailableBalance(ud.getAvailableBalance() - amount - this.transactionFee);
						Transaction t = new Transaction("WithDrawal",amount, ud.getAvailableBalance());
						ud.addTransaction(t);
					}else {
						System.out.println("Insufficient balance in your account");
					}
				}else {
					System.out.println("Insufficient cash in ATM");
				}
			}

			if (line.equals("3")) {
				System.out.println("Enter amount to deposit");
				double amount = Math.abs(Double.valueOf(scan.nextLine()));
				ud.setAvailableBalance(ud.getAvailableBalance() + amount);
				this.availableAmountInMachine = this.availableAmountInMachine + amount;
				Transaction t = new Transaction("Deposit",amount, ud.getAvailableBalance());
				ud.addTransaction(t);
			}

			if (line.equals("4")) {
				ud.displayTransaction();
			}

			if (line.equals("5")) {

				int retryCount = 3;
				while(retryCount > 0) {
					System.out.println("Enter Old password");
					String pwd = scan.nextLine();
					if(ud.getPassword().compareTo(pwd) == 0){
						System.out.println("Enter new password");
						pwd = scan.nextLine();
						ud.setPassword(pwd);
						break;
					}else {
						System.out.println("Entered Incorrect password, try again");
					}
					retryCount--;
				}
			}

			if (line.equals("6")) {
				System.out.println("ATM session ended");
				break;
			}
		}
	}


	public static void main(String[] args) {
		UserData ud1 = new UserData("John", 30, "Bothell WA","4255950123", "12345", 10000.0 );
		UserData ud2 = new UserData("Adam", 40, "Seattle WA","4255950124", "23451", 20000.0 );
		UserData ud3 = new UserData("Mark", 35, "Redmond WA","4255950193", "32345", 30000.0 );
		UserData ud4 = new UserData("Tony", 25, "Bellevue WA","4254950123", "42345", 40000.0 );
		UserData ud5 = new UserData("Justin", 23, "Renton WA","4259950123", "52345", 50000.0 );

		ArrayList<UserData> userDataList = new ArrayList<>();
		userDataList.add(ud1);
		userDataList.add(ud2);
		userDataList.add(ud3);
		userDataList.add(ud4);
		userDataList.add(ud5);

		Atm atm = new Atm(100000.0,5.0,userDataList);
		atm.start();
	}
}
