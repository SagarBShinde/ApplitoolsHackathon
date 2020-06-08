package sbs.applitools.hackathon.test.uivalidation;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sbs.applitools.hackathon.framework.baseTest.BaseTest;
import sbs.applitools.hackathon.framework.dataProvider.TestState;
import sbs.applitools.hackathon.framework.setup.TestTarget;


@TestState("LAPTOP_ALL")
public class FirstTest2 extends BaseTest {
	 	
	
	    public FirstTest2(TestTarget target) {
	        this.testTarget = target;
	    }
	    
	    public FirstTest2() {
	    }
	 
	    @BeforeClass
	    public void beforeClass() {
	        System.out.println("Before SimpleTest class executed.");
	    }
	 
	    @Test
	    public void testMethod() {
	    	System.out.println("testMethod parameter value is: " + testTarget.targetName);
	    	System.out.println("testMethod parameter value is: " + testTarget.device.deviceType);
	    	
	    }
	    

	
}
