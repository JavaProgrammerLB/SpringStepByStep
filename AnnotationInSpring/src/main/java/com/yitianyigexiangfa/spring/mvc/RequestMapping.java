package com.yitianyigexiangfa.spring.mvc;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {
	
	String name() default "";
	
	@AliasFor("path")
	String[] value() default{};
	
	@AliasFor("value")
	String[] path() default {};
	
	RequestMethod[] method() default {};
	
	String[] params() default {};
	
	String[] consumes() default {};
	
	String[] produces() default{};
}
