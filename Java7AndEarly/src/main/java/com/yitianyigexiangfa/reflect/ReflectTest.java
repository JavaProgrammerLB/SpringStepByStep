package com.yitianyigexiangfa.reflect;

public class ReflectTest {

	public ReflectTest() {
	}
	
	public static void main(String[] args) {
		Class c = "foo".getClass();
		boolean b = false;
		Class c2 = boolean.class;
		Class c3 = java.io.PrintStream.class;
		Class c4 = int[][][].class;

		System.out.println(c);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
	}

}
