package com.cg.bvrit.service;

import java.util.List;
import com.cg.bvrit.bean.BankDetalils;
import com.cg.bvrit.bean.BankTransactions;
import com.cg.bvrit.util.AccountNotFoundException;


public interface BankService {

	boolean custNameOk(String custName);

	boolean mobNoValidate(long mobile);

	boolean accTypeValidate(String accType);

	boolean createAccount(BankDetalils cust);

	BankDetalils deposit(long nextLong, double nextDouble);

	BankDetalils getCustomer(long accNo);

	BankDetalils transferMoney(long accNoFrom, long accNoTo , double transMoney);

	BankDetalils withdraw(long accno, double amount) throws AccountNotFoundException;

    List<BankTransactions> getTransactions(long myAccNo);

	void printlist(List<BankTransactions> transactions);

	
	

}
