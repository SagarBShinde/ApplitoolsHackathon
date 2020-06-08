package sbs.applitools.hackathon.framework.dataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.ITestContext;

import sbs.applitools.hackathon.framework.utils.JSONUtils;
import sbs.applitools.hackathon.framework.utils.JSONUtilsGsonImpl;;

public class DataProviderJsonImpl implements ProvidesData {

	private static final String DEFAULT_DATA_FILE = System.getProperty("user.dir")+ "//config//testData.json";

	@Override
	public Object[][] getData(ITestContext iTestContext, Method testMethod) throws IOException {
		
		
		DataSet dataSetName = testMethod.getAnnotation(DataSet.class);
		String param = dataSetName.value();
		String file = iTestContext.getCurrentXmlTest().getParameter("data_file");
		
		if (file == null){
			// Getting xml data file from System Property - Used for Jenkins
			file = System.getProperty("data_file",DEFAULT_DATA_FILE);

		}
		
		String DataJson= new String(Files.readAllBytes(Paths.get(file)));
		
		JSONUtils jsonHelper = new JSONUtilsGsonImpl(DataJson);
		JSONArray dataArray = jsonHelper.getJSONObject(param).getJSONArray("Data");
		Object[][] testData= new Object[dataArray.length()][];
		
		for (int i=0; i< dataArray.length(); i++) {
			List<String> paramList= new ArrayList<String>();
			JSONArray parameterArray =(JSONArray) dataArray.get(i);
			for (int j=0; j< parameterArray.length(); j++) {
				JSONObject parameterObject= parameterArray.getJSONObject(j);
				System.out.println("Key is:"+parameterObject.keys().next().toString());
				String parameterValue= parameterObject.getString(parameterObject.keys().next());
				System.out.println("Value is:"+parameterValue);
				paramList.add(parameterValue);
				}
			String[] paramArr = new String[paramList.size()];
			testData[i]= paramList.toArray(paramArr);
			}
			    
		return testData;
	}


}
