package com.yitianyigexiangfa.system;

public class SystemGo {

	public SystemGo() {
	}

	public static void main(String[] args) {
		String cwd = System.getProperty("user.dir");
		String javaRuntimeVersion = System.getProperty("java.runtime.version");
		String jvmInfo = System.getProperty("java.vm.info");
		String jvmVersion = System.getProperty("java.vm.version");
		String jvmvendor = System.getProperty("java.vm.vendor");
		String jvmName = System.getProperty("java.vm.name");
		System.out.println(cwd);
		System.out.println(javaRuntimeVersion);
		System.out.println(jvmInfo);
		System.out.println(jvmVersion);
		System.out.println(jvmvendor);
		System.out.println(jvmName);
		
	}

}
