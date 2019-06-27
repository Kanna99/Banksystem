package com.cg.bvrit.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.cg.bvrit.bean.BankDetalils;
import com.cg.bvrit.bean.BankTransactions;
import com.cg.bvrit.dao.BankDaoImpl;
import com.cg.bvrit.service.BankService;
import com.cg.bvrit.service.BankServiceImpl;
import com.cg.bvrit.util.AccountNotFoundException;

public class BankClient {


	private BankService eService;
    private static long seq=1000;

	public BankClient() throws AccountNotFoundException {
		eService = new BankServiceImpl();

		Scanner scan = new Scanner(System.in);
		while (true) {
			int choice = getChoice(scan);
			switch (choice) {
			case 1:
				String custName = null;
				long mobile = 0;
				String accType = null;
				String branch = null;
				System.out.println("Create Account");

				/* Name input */

				boolean isOkName = false;
				System.out.println("Enter Customer Name");
				 scan.nextLine();
				do {
				
					
					custName = scan.nextLine();
					isOkName = eService.custNameOk(custName);
					
					if (!isOkName) {
						System.out.println(" Please enter alphabets only ");
						System.out.println("Enter Customer Name");
					}

				} while (!isOkName);

				/* Mobile Number Input */

				boolean isMobileOk = false;
				do {
					 
						System.out.println("Enter Mobile Number");
						mobile = scan.nextLong();
						isMobileOk = eService.mobNoValidate(mobile);

						if (!isMobileOk) {

							 throw new AccountNotFoundException("Enter 10 digit valid mobile number ");
						}

				 

				} while (!isMobileOk);

				/* Type of Account */

				boolean isAccTypeOk = false;
				do {
					try {
						System.out.println("Enter Type of account");
						accType = scan.next();
						if (eService.accTypeValidate(accType))
							isAccTypeOk = true;
						else {
							System.out.println(" Enter savings or current A/C  ");
						}
					} catch (Exception e) {
						System.out.println(" Invalid aaccount type ");

					}
				} while (!isAccTypeOk);

				/* Branch Name */
				boolean isBranchOk = false;
				do {
					try {
						System.out.println("Enter Branch name");
						branch = scan.next();
						isBranchOk = true;
					} catch (Exception e) {
						System.out.println("Enter alphabets only  ");
					}
				} while (!isBranchOk);

				System.out.println("Enter balance");
				String balance = scan.next();
				BankDetalils cust = new BankDetalils( seq++, custName, mobile, accType, branch, Double.parseDouble(balance));
				boolean success;
				try {
					success = eService.createAccount(cust);
					if (success) {
						System.out.println("Account created");
						System.out.println("Your Acount No: " + cust.getAccNo());
						System.out.println();
					} else {
						System.out.println("Failed to create account");
						System.out.println();
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Deposit Amount");
				System.out.println("Enter <Acc number> <Amount to deposit>");
				BankDetalils cust2 = eService.deposit(scan.nextLong(), scan.nextDouble());
				if (cust2 == null) {
					System.out.println("Account does not exist");
				} else {

					print(cust2);
				}
				break;
			case 3:
				System.out.println("Withdraw Amount");
				System.out.println("Enter <Acc number> <Amount to withdraw>");

				try {
					long accno = scan.nextLong();
					double amount = scan.nextDouble();
					BankDetalils cust3 = eService.withdraw(accno, amount);

					if (cust3 != null && amount <= cust3.getBalance())
						
						 print(cust3); 
					
					// else { System.out.println(" Insufficient Balance "); }

				} catch (Exception e) {
					System.out.println();
				}

				break;
			case 4:
				System.out.println("Get Cust details");
				System.out.println("Enter Acc Number");
				long accNo = scan.nextLong();
				BankDetalils cust1 = null;
				try {

					cust1 = eService.getCustomer(accNo);
					if (cust1 != null)
						print(cust1);
					else
						System.out.println(" Acc No does not exist ");
				} catch (Exception e) {
					System.out.println("Invalid Account No ");
				}
				break;

			case 5:
				System.out.println("Money Transfer ");

				System.out.println("Enter your Account No ");
				long accNo1 = scan.nextLong();
				System.out.println(" Enter the Account no to which you want to transfer money ");
				long accNo2 = scan.nextLong();

				System.out.println(" Enter the Amount you want to transfer ");
				double transMoney = scan.nextDouble();

				BankDetalils custFinal = eService.transferMoney(accNo1, accNo2, transMoney);

				if (custFinal != null)
					print(custFinal);

				break;

		   case 6: System.out.println(" Transaction Details "); 
				   System.out.println(" Enter Account No ");
				   long myAccNo=scan.nextLong();
				   List <BankTransactions>  Transactions=new ArrayList<>();
						   
				   Transactions= eService.getTransactions(myAccNo);
				  
				   eService.printlist(Transactions);
				   
				   
				  break;
				
		    case 7:
				System.out.println("Thank you. Good bye.");
				
				System.exit(0);
				break;
				
			default:
				System.out.println("Please choose 1 to 7 only");
				break;
			}
		}

	}


	private void print(BankDetalils cust) {
		System.out.printf("%-15s %s\n", "Acc No.", cust.getAccNo());
		System.out.printf("%-15s %s\n", "Cust Name:", cust.getCustName());
		System.out.printf("%-15s %s\n", "Mobile ", cust.getMobile());
		System.out.printf("%-15s %s\n", "Acc Type ", cust.getAccType());
		System.out.printf("%-15s %s\n", "Branch", cust.getBranch());
		System.out.printf("%-15s %s\n", "Balance ", cust.getBalance());

	}

	private int getChoice(Scanner scan) {
		int choice = 0;
		System.out.println("  Bank Services...! ");
		System.out.println("**********************************************************");
		System.out.println("1. Create Account");
		System.out.println("2. Deposit ");
		System.out.println("3. Withdraw");
		System.out.println("4. Show customer details");
		System.out.println("5. Fund Transfer");
		System.out.println("6. Show Transaction Details ");
		System.out.println("7. Exit Application");
		System.out.println("Enter Your Choice");
		try {
			choice = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please enter number only");
			scan.nextLine();// consume the keyboard input
		}
		return choice;
	}


	public static void main(String[] args) throws AccountNotFoundException {
		// TODO Auto-generated method stub

		new BankClient();
	
	
	}

}
