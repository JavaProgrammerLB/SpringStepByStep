package com.yitianyigexiangfa.log4j20170601;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j {

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
		logger.entry();
		logger.error("Did it again!");
	}

}
