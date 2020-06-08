package sbs.applitools.hackathon.framework.dataProvider;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestState {
	
	String NO_PARAMETER = "NO_PARAMETER";
	
	/**
	 * Parameter for data provider 
	 */
	String value() default DataSet.NO_PARAMETER;

}