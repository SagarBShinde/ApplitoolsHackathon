package sbs.ufg.hackathon.traditional.v2.framework.dataProvider;
import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.ITestContext;


public interface ProvidesData {
	
		Object[][] getData(ITestContext iTestContext, Method testMethod) throws IOException;
		

}
