package com.yitianyigexiangfa;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4j2Helloworld {
	
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
		logger.error("hello error");
	}

}
