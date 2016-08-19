package com.yitianyigexiangfa.spring.di;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Bean {
	String[] name() default {};
	
	// Autowire autowire() default Autowire.NO;
	
	String initMethod() default "";
	
	//String destroyMethod() default AbstractBeanDefinition.INFER_METHOD;
}
