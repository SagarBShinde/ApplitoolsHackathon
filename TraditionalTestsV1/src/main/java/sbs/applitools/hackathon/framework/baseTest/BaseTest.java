package sbs.applitools.hackathon.framework.baseTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Factory;

import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.framework.utils.JSONUtils;
import sbs.applitools.hackathon.framework.utils.JSONUtilsGsonImpl;

public class BaseTest {
	
	
	public TestTarget testTarget;
	
	
	
	@Factory
    public Object[] factMethod() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        		
		
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("test_targets.json");		
		String TargetJson = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
			      .lines()
			      .collect(Collectors.joining("\n"));
	    
		System.out.println(TargetJson);
		JSONUtils jsonUtil =  new JSONUtilsGsonImpl(TargetJson);
		System.out.println(jsonUtil.getJSONArray("Laptop_all"));
		
		List<Object> testList = new ArrayList<Object>();
		TestTarget[] targets = (TestTarget[]) jsonUtil.getObject(jsonUtil.getJSONArray("Laptop_all").toString(), TestTarget[].class);
		System.out.println(targets.length);
		for(TestTarget target : targets) {
			try {
				testList.add(this.getClass().getConstructor(TestTarget.class).newInstance(target));
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}	
		}

		System.out.println(testList.toArray().length);
		return testList.toArray();

    
	}

				
}
