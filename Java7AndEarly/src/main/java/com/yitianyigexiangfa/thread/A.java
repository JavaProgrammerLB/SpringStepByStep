package com.yitianyigexiangfa.thread;

public class A {

	public A() {
	}

	synchronized void funA(B b) {
		String name = Thread.currentThread().getName();
		System.out.println(name + " 进入 A.foo ");
		try {
			Thread.sleep(1000);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(name + " 调用 B 类中的 last()方法");
		b.last();
	}

	synchronized void last() {
		System.out.println("Aaa 类中的 last()方法");
	}

}
