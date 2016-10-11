package com.yitianyigexiangfa.time;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Counter {

	public Counter() {
	}

	private static int cnt;

	public static void main(String args[]) {

		new JFrame().setVisible(true);

		ActionListener actListner = new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				cnt += 1;
				System.out.println("Counter = " + cnt);
			}
		};

		Timer timer = new Timer(5000, actListner);

		timer.start();
	}

}
