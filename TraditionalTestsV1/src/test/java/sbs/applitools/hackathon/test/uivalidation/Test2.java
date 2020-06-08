package sbs.applitools.hackathon.test.uivalidation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Test2 {
	
	    private String param = "";
	 
	    public Test2(String param) {
	        this.param = param;
	    }
	 
	    @BeforeClass
	    public void beforeClass() {
	        System.out.println("In the before class Test 2----------------");
	    }
	 
	    @Test
	    public void testMethod() {
	        System.out.println("In the Test Test2 " + param);
	    }
	
}
