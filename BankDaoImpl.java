package com.cg.bvrit.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.bvrit.bean.BankDetalils;
import com.cg.bvrit.bean.BankTransactions;
import com.cg.bvrit.util.AccountNotFoundException;
import com.cg.bvrit.util.Messages;

public class BankDaoImpl implements BankDao {
	 public final int MIN_BALANCE=3000;
		private Map<Long, BankDetalils> custMap;
	    

	public BankDaoImpl() {
	 
		custMap = new HashMap<>();
		
    }

	@Override
	public boolean createAccount(BankDetalils cust) {
		custMap.put(cust.getAccNo(), cust);

		return true;
	}

	@Override
	public BankDetalils transferMoney(long accNoFrom , long accNoTo , double transMoney) {
		
		
		BankDetalils custFrom = custMap.get(accNoFrom);
		
		if (custFrom == null) {
			System.out.println(" Your Account no does not exist ");
			return custFrom;
		}

		BankDetalils custTo = custMap.get(accNoTo);
		
		if (custTo == null) {
			System.out.println(" The  Account to which you want to transfer money does not exist ");
			return custTo;
		}

		double custFromBal = custFrom.getBalance();
		double custToBal = custTo.getBalance();

		if (custFrom != null && custTo != null) {
			if (custFromBal >= transMoney) {
			
				custTo.setBalance(transMoney + custToBal);
				custFrom.setBalance(custFromBal - transMoney);
				custMap.put(  accNoFrom , custFrom);
				custMap.put(  accNoTo , custTo);
				
		//		EWalletTransDetails transdetails=new EWalletTransDetails
		//				( 0 , accNoFrom, accNoTo , transMoney , new Date() , "transfer" ,custFrom.getBalance());
			  //     em.persist(transdetails);
			
			} else {
				System.out.println(" Insuficient Balance to transfer");
			}

		}

		return custFrom;
		
		
	}

	@Override
	public BankDetalils getCustomer(long accNo) {
		return custMap.get(accNo);
	}

	@Override
	public BankDetalils deposit(long accNo, double amount) {
		BankDetalils cust=custMap.get(accNo);
		if(cust!=null) {
			double balance=cust.getBalance();
			balance+=amount;
			cust.setBalance(balance);
		}
		return cust;
	}

	@Override
	public List<BankTransactions> getTransactions(long myAccNo) {
		
		List l=null;
		
		
		return l;
	}

	@Override
	public BankDetalils withdraw(long accNo, double amount) throws AccountNotFoundException {
		BankDetalils cust=custMap.get(accNo);
		if(cust!=null) {
			double balance=cust.getBalance();
			balance-=amount;
			cust.setBalance(balance);
			if(balance<MIN_BALANCE) {
				throw new AccountNotFoundException(Messages.INSUFFICIENT_BALANCE);
			}
		}
		
		return cust;
	}

}
