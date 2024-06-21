package com.assign2.multistreams.thread;

public class MultithreadSynchDemo implements Runnable {
	private static int counter = 1;
	private static final Object lock = new Object();

	@Override
	public void run() {
		while (counter <= 10) {
			synchronized (lock) {
				if (counter % 2 == 0) {
					System.out.println(counter + " Written By Thread-" + Thread.currentThread().getName());
					counter++;
					try {
						lock.notifyAll();
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				} else if (counter % 2 == 1) {
					System.out.println(counter + " Written By Thread-" + Thread.currentThread().getName());
					counter++;

					try {
						lock.notifyAll();
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new MultithreadSynchDemo(), "1");
		t1.start();
		Thread t2 = new Thread(new MultithreadSynchDemo(), "2");
		t2.start();
		
		
	}

}
