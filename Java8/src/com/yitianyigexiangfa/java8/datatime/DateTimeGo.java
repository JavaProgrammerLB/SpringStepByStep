package com.yitianyigexiangfa.java8.datatime;

import java.time.LocalDate;

public class DateTimeGo {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2016, 05, 20);
		System.out.println("Month:" + date.getMonth());
		System.out.println("Isn't leap year:" + date.isLeapYear());
	}

}
