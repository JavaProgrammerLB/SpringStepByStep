package com.yitianyigexiangfa.thread.oracle.tutorial;

public class HelloRunnable implements Runnable {

	public HelloRunnable() {
	}

	public void run() {
		System.out.println("Hello from a thread!");
	}

	public static void main(String[] args) {
		(new Thread(new HelloRunnable())).start();
	}
}
