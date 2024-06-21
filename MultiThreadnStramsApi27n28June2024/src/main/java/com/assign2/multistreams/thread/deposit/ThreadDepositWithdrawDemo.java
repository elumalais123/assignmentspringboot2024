package com.assign2.multistreams.thread.deposit;

public class ThreadDepositWithdrawDemo extends Thread implements Runnable {

	private Person person;

	public ThreadDepositWithdrawDemo(Person p) {
	    this.person = p;
	}

	public static void main(String[] args) {

		ThreadDepositWithdrawDemo ts1 = new ThreadDepositWithdrawDemo(new Person("person 1"));
	    ts1.start();
	    ThreadDepositWithdrawDemo ts2 = new ThreadDepositWithdrawDemo(new Person("person 2"));
	    ts2.start();
	    ThreadDepositWithdrawDemo ts3 = new ThreadDepositWithdrawDemo(new Person("person 3"));
	    ts3.start();

	}

	@Override
	public void run() {
	    for (int i = 0; i < 3; i++) {
	        try {
	            Account acc = Account.getAccount(person);
	            acc.withdraw(100);
	            try {
	                Thread.sleep(200);
	            } catch (InterruptedException ex) {
	                System.out.println(ex.getStackTrace());
	            }
	            if (acc.getBal() < 0) {
	                System.out.println("account is overdrawn!");
	            }
	            acc.deposit(200);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    System.out.println("Final Acc balance is Rs." + Account.getBal());
	}
}
