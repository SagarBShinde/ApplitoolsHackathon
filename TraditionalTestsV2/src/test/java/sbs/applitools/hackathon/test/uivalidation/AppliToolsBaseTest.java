package sbs.applitools.hackathon.test.uivalidation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.testng.asserts.SoftAssert;

import sbs.applitools.hackathon.framework.baseTest.BaseTest;
import sbs.applitools.hackathon.framework.excptions.ReporterException;
import sbs.applitools.hackathon.framework.utils.Utils;

public class AppliToolsBaseTest extends BaseTest {
	
	
	public SoftAssert runUIValidationForElement(Map<String,String> compareResult, StringBuilder reportRec) throws ReporterException {
		SoftAssert softAssertion= new SoftAssert();
		Iterator<String> itr = compareResult.keySet().iterator();
		 
		ArrayList<String> ui_validations =  new ArrayList<String>();
		
		while(itr.hasNext()) {
			String result = itr.next();
			softAssertion.assertEquals(compareResult.get(result), "Pass");
			ui_validations.add(compareResult.get(result));
		}
		reportRec.append("Status:"+ Utils.deriveStatus(ui_validations));
		this.report.write(reportRec.toString());
		return softAssertion;
		
		
	}

}
