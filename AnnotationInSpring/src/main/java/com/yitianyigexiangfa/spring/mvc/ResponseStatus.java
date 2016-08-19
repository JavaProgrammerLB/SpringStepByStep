package com.yitianyigexiangfa.spring.mvc;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface ResponseStatus {
	//@AliasFor("code")
	//HttpStatus value() default HttpStatus.INTERNAL_SERVER_ERROR;
	
	//@AliasFor("value")
	//HttpStatus code() default HttpStatus.INTERNAL_SERVER_ERROR;
	
	String reason() default "";
}
