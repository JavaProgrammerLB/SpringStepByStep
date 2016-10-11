package com.yitianyigexiangfa.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {

	public CopyCharacters() {
	}

	public static void main(String[] args) throws IOException {
		FileReader inputStream = null;
		FileWriter outputstream = null;
		
		try {
			inputStream = new FileReader("liubeiIn.txt");
			outputstream = new FileWriter("characteroutput.txt");
			
			int c;
			while ((c = inputStream.read()) != -1) {
				outputstream.write(c);
				System.out.println(c);
			}
		} finally{
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputstream != null){
				outputstream.close();
			}
		}
	}
}
