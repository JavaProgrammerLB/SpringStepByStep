package com.yitianyigexiangfa.thread.oracle.tutorial;

public class SleepMessages {

	public SleepMessages() {
	}

	public static void main(String[] args) throws InterruptedException {
		String impotantInfo[] = { "Mares eat oats", "Does eat oats",
				"Little lambs eat ivy", "A kid will eat ivy too" };
		for (int i = 0; i < impotantInfo.length; i++) {
			String info = impotantInfo[i];
			Thread.sleep(4000);
			System.out.println(info);
		}
	}

}
