package com.yitianyigexiangfa.spring.mvc;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Target;

@Target(TYPE)
public @interface Table {
	
	public String tableName() default "classname";

}
