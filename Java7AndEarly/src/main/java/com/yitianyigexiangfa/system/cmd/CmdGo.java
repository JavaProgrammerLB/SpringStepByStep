package com.yitianyigexiangfa.system.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdGo {

	public CmdGo() {
	}

	public static void main(String[] args) throws InterruptedException {
		try {
			Process p = Runtime.getRuntime().exec("javac");
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			System.out.println("hello");
			while((line = in.readLine()) != null){
				System.out.println(line);
			}
			int exitVal = p.waitFor();
			System.out.println("Process exitValue：" + exitVal);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
