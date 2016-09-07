package com.yitianyigexiangfa.thread;

public class SynchronizedLock implements Runnable{

	public void run() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread() + "synchronized loop" + i);
			}
		}
	}
	
	public static void main(String[] args) {
		SynchronizedLock lock1 = new SynchronizedLock();
		Thread ta = new Thread(lock1, "A");
		Thread tb = new Thread(lock1, "B");
		ta.start();
		tb.start();
	}
	
}
