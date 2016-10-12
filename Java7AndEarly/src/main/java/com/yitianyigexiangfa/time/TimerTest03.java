package com.yitianyigexiangfa.time;

import java.util.Timer;

public class TimerTest03 {
	Timer timer;
	
	public TimerTest03() {
		timer = new Timer();
		timer.schedule(new TimerTaskTest03(), 1000, 30000);
	}
	
	public static void main(String[] args) {
		new TimerTest03();
	}
}
