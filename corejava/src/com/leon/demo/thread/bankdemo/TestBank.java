package com.leon.demo.thread.bankdemo;

public class TestBank {
	public static void main(String[] args) {
		BankAccount ba = new BankAccount("6225886000618437","WANG",1000);
		for (int i = 1; i < 5; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"启动");
					for (int j = 0; ; j++) {
						System.out.println(Thread.currentThread().getName()+"第"+j+"次存钱");
						ba.storeMoney(500);
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			},"存钱线程"+i).start();
		}
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"启动");
					for (int j = 1; ; j++) {
						System.out.println(Thread.currentThread().getName()+"第"+j+"次取钱");
						ba.withdraw(700);
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			},"取钱线程"+i).start();
		}
		
	}
}
