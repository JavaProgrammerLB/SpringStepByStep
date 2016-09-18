package com.yitianyigexiangfa.thread;

public class DeadLockDemo implements Runnable {
	
	A a = new A();
	B b = new B();

	public DeadLockDemo() {
		// 设置当前线程的名称
		Thread.currentThread().setName("Main -->> Thread");
		new Thread(this).start();
		a.funA(b);
		System.out.println("main 线程运行完毕");
	}

	public void run() {
		Thread.currentThread().setName("Test -->> Thread");
		b.funB(a);
		System.out.println("其他线程运行完毕");
	}

	public static void main(String[] args) {
		new DeadLockDemo();
	}

}
