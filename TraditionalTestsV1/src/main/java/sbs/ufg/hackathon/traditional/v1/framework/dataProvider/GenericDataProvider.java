package sbs.ufg.hackathon.traditional.v1.framework.dataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class GenericDataProvider {
	
	@DataProvider(name = "TEST", parallel = false)

	public  Object[][] getData(ITestContext iTestContext, Method testMethod) throws IOException {

		ProvidesData dataProvider= new DataProviderJsonImpl();
		return dataProvider.getData(iTestContext, testMethod);
		
	}
	
}
