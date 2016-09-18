package com.yitianyigexiangfa.thread;

public class B {

	public B() {
	}

	synchronized void funB(A a) {
		String name = Thread.currentThread().getName();
		System.out.println(name + " 进入 B 类中的");
		try {
			Thread.sleep(2000);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(name + " 调用 A 类中的 last()方法");
		a.last();
	}

	synchronized void last() {
		System.out.println("Bbb 类中的 last()方法");
	}
}
