package sbs.applitools.hackathon.test.uivalidation;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sbs.applitools.hackathon.framework.baseTest.BaseTest;
import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.framework.setup.TestTargetList;



@TestTargetList({"Default","Laptop_all"})
public class FirstTest2 extends BaseTest {
	 	
	private static final Logger LOG = LogManager.getLogger(FirstTest2.class);
	
	 
	 
	    @BeforeClass
	    public void beforeClass() {
	        System.out.println("Before SimpleTest class executed.");
	    }
	 
//	    @Test
//	    public void testMethod() {
//	    	System.out.println("testMethod parameter value is: " + testTarget.targetName);
//	    	System.out.println("testMethod parameter value is: " + testTarget.device.deviceType);
//	    	
//	    }
	    

	
}
