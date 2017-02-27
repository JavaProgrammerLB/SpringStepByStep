package com.yitianyigexiangfa.system;

public class SystemArrayCopy {

	public SystemArrayCopy() {
	}

	public static void main(String[] args) {
		SystemArrayCopy obj = new SystemArrayCopy();
		obj.test();
	}
	
	public void test(){
		String[] params = new String[]{
			"liubei", "yuanmengchen", "alice", "oldsix"	
		};
		String[] arry = new String[3];
		System.arraycopy(params, 1, arry, 0, 3);
		for (String arr : arry) {			
			System.out.println(arr);
		}
	}

}
