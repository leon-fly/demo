package com.leon.demo.concurrent.bankdemo;

public class BankAccount {
	private String accountid;
	private String accountName;
	private double balance;

	public BankAccount() {
		super();
	}

	public BankAccount(String accountid, String accountName) {
		super();
		this.accountid = accountid;
		this.accountName = accountName;
	}

	public BankAccount(String accountid, String accountName, double balance) {
		super();
		this.accountid = accountid;
		this.accountName = accountName;
		this.balance = balance;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public synchronized boolean storeMoney(double num) {
		Double beforemoney = getBalance();
		this.setBalance(this.getBalance()+num);
		System.out.println("账户号："+this.getAccountid()+"\t原余额："+beforemoney+"\t存入金额："+num+"\t存入后余额："+this.getBalance());
		return true;
	}
	
	public synchronized boolean withdraw(double num){
		if(this.getBalance()<num){
			System.out.println("账户号："+this.getAccountid()+"\t余额："+this.getBalance()+"\t余额不足！！！！！！！！！！！！！");
			return false;
		}
		Double beforemoney = getBalance();
		this.setBalance(this.getBalance()-num);
		System.out.println("账户号："+this.getAccountid()+"\t原余额："+beforemoney+"\t取出金额："+num+"\t取出后余额："+this.getBalance());
		return true;
	}
}
