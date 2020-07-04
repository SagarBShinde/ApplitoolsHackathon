package sbs.ufg.hackathon.traditional.v2.framework.dataProvider;


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