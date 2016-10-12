package com.yitianyigexiangfa.time;

import java.util.Date;
import java.util.TimerTask;

public class TimerTaskTest03 extends TimerTask {

	public TimerTaskTest03() {
	}

	@Override
	public void run() {
		Date date = new Date(this.scheduledExecutionTime());
		System.out.println("本次执行该线程的时间为：" + date);
	}

}
