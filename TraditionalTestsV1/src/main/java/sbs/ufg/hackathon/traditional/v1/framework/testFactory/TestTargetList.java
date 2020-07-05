package sbs.ufg.hackathon.traditional.v1.framework.testFactory;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestTargetList {
	
	String DEFAULT_PARAMETER = "Default";
	
	/**
	 * Parameter for data provider 
	 */
	String[] value() default TestTargetList.DEFAULT_PARAMETER;

}