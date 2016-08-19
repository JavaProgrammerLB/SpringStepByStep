package com.yitianyigexiangfa.spring.di;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.yitianyigexiangfa.spring.mvc.AliasFor;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ContextConfiguration {
	@AliasFor("locations")
	String[] value() default {};
	
	@AliasFor("value")
	String[] locations() default{};
	
	Class<?>[] classes() default{};
	
//	Class<?  extends ApplicationContextInitializer<? extends ConfigurableApplicationContext>>[] initializers() default{};
	
	boolean inheritLocations() default true;
	
	boolean inheritInitializers() default true;
	
//	Class<? extends ContextLoader> loader() default ContextLoader.class;
	
	String name() default "";
}
