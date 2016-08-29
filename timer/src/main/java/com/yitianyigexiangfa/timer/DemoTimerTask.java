package com.yitianyigexiangfa.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DemoTimerTask {
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("这是一个定时任务！");
			}
		};
		
		Date time = new Date();
		long delay = 0;
		long period = 1000;
		
		timer.schedule(task, delay, period);
	}
}	
