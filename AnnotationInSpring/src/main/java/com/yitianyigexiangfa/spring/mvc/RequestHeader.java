package com.yitianyigexiangfa.spring.mvc;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(PARAMETER)
public @interface RequestHeader {
	@AliasFor("name")
	String value() default "";
	
	@AliasFor("value")
	String name() default "";
	
	boolean required() default true;
	
	//String defaultVelue() default ValueConstants.DEFAULT_NONE;
}
