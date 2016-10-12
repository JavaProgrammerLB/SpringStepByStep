package com.yitianyigexiangfa.time;

import java.util.TimerTask;

public class TimerTaskTest02 extends TimerTask {

	public TimerTaskTest02() {
	}

	@Override
	public void run() {
		System.out.println("指定时间执行线程任务……");
	}

}
