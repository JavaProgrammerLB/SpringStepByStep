package com.yitianyigexiangfa.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HelloWorldSwing {
	
	public HelloWorldSwing() {
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	private static void createAndShowGUI(){
		JFrame frame = new JFrame("HelloWorldSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Hello World");
		frame.getContentPane().add(label);
		frame.pack();
		frame.setVisible(true);
	}

}
