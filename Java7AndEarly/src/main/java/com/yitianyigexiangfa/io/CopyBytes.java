package com.yitianyigexiangfa.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {

	public CopyBytes() {
	}

	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream("liubeiIn.txt");
			out = new FileOutputStream("liubeiOut.txt");
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
				System.out.println(c);
			}
		} finally{
			if (in != null) {
				in.close();
			}
			if (out != null){
				out.close();
			}
		}
	}

}
