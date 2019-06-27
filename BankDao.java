package com.cg.bvrit.dao;

import java.util.List;

import com.cg.bvrit.bean.BankDetalils;
import com.cg.bvrit.bean.BankTransactions;
import com.cg.bvrit.util.AccountNotFoundException;

public interface BankDao {

	boolean createAccount(BankDetalils cust);

	BankDetalils transferMoney(long accNoFrom, long accNoTo , double transMoney);

	BankDetalils getCustomer(long accNo);

	BankDetalils deposit(long accNo, double amount);

	List<BankTransactions> getTransactions(long myAccNo);

	BankDetalils withdraw(long accNo, double amount) throws AccountNotFoundException;

}
