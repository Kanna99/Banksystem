package com.cg.bvrit.service;

import java.util.List;
import com.cg.bvrit.bean.BankDetalils;
import com.cg.bvrit.bean.BankTransactions;
import com.cg.bvrit.dao.BankDao;
import com.cg.bvrit.dao.BankDaoImpl;
import com.cg.bvrit.util.AccountNotFoundException;

public class BankServiceImpl implements BankService {
	private BankDao eDao;
	public BankServiceImpl() {
		eDao = new BankDaoImpl();
	}
	@Override
	public boolean custNameOk(String custName) {
		if (custName.matches("[A-Z][a-zA-Z ]*"))
			return true;
		else
		return false;
	}
	@Override
	public boolean mobNoValidate(long mobile) {
		String mob = Long.toString(mobile);
		if (mob.matches("[6-9][0-9]{9}"))
			return true;
		else
		return false;
	}

	@Override
	public boolean accTypeValidate(String accType) {
		
		if (accType.equalsIgnoreCase("savings") || accType.equalsIgnoreCase("current"))
			return true;
		else
		return false;
		
	}

	@Override
	public boolean createAccount(BankDetalils cust) {
		// TODO Auto-generated method stub
		 return eDao.createAccount(cust);
	}

	@Override
	public BankDetalils deposit(long accNo, double amount) {
		// TODO Auto-generated method stub
		return eDao.deposit(accNo, amount);
	}

	@Override
	public BankDetalils getCustomer(long accNo) {
		// TODO Auto-generated method stub
		return eDao.getCustomer(accNo);
	}

	@Override
	public BankDetalils transferMoney(long accNoFrom , long accNoTo , double transMoney) {
		// TODO Auto-generated method stub
		return eDao.transferMoney(accNoFrom , accNoTo, transMoney);
	}


	@Override
	public BankDetalils withdraw(long accNo, double amount) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		return eDao.withdraw(accNo, amount);
		
	}


	@Override
	public List<BankTransactions> getTransactions(long myAccNo) {
		// TODO Auto-generated method stub
	   return eDao.getTransactions(myAccNo);
	}


	@Override
	public void printlist(List<BankTransactions> transactions) {
		// TODO Auto-generated method stub
		
		 double balance=0;
			
			System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s" ,
					"transId","accNoFrom","accNoTo","amount","dateOfTrans"," transType", "balance" );
			System.out.println();
			for( BankTransactions e :transactions) {
				System.out.println();
				System.out.printf("%-15d %-15s %-15s %-15s %-15s %-15s %-15s" , 
		        e.getTransId(),e.getAccNoFrom(),e.getAccNoTo(),
		        e.getAmount(), e.getDateOfTrans(), e.getTransType(),e.getBalance() ); 
				System.out.println();
				 balance = e.getBalance();
			}
		
		 System.out.println("\n \n  Your current Balance is "+ balance );	
	     System.out.println();
		
	}

}
