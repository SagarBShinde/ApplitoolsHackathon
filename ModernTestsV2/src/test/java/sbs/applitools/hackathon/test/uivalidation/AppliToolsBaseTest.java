package sbs.applitools.hackathon.test.uivalidation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.testng.asserts.SoftAssert;

import com.applitools.eyes.TestResultContainer;

import sbs.applitools.hackathon.framework.baseTest.BaseTest;
import sbs.applitools.hackathon.framework.excptions.ReporterException;
import sbs.applitools.hackathon.framework.excptions.UnsupportedTestTargetException;
import sbs.applitools.hackathon.framework.setup.TestTarget;
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
	
	protected TestResultContainer findResultsForTarget(TestTarget target) throws UnsupportedTestTargetException {
		
		switch (target.device.deviceType.toString()){
		
		case "LAPTOP":
			for(TestResultContainer result: this.testResults) {
				if (result.getBrowserInfo().getViewportSize() != null && result.getBrowserInfo().getBrowserType().toString().equalsIgnoreCase(target.browser.browserName)  && result.getBrowserInfo().getViewportSize().toString().equalsIgnoreCase(target.browserSize.toString())) {
					return result;
				}	
			}
			throw new UnsupportedTestTargetException("No UFG Results found for Test Target:" + target.toString());
		case "TABLET":
			for(TestResultContainer result: this.testResults) {
				if (result.getBrowserInfo().getViewportSize() != null && result.getBrowserInfo().getBrowserType().toString().equalsIgnoreCase(target.browser.browserName)  && result.getBrowserInfo().getViewportSize().toString() == target.browserSize.toString()) {
					return result;
				}	
			}	
			throw new UnsupportedTestTargetException("No UFG Results found for Test Target:" + target.toString());
		case "MOBILE":
			for(TestResultContainer result: this.testResults) {
				if (result.getBrowserInfo().getEmulationInfo()!= null && result.getBrowserInfo().getEmulationInfo().getDeviceName().toString().equalsIgnoreCase(target.device.deviceName)) {
					return result;
				}	
			}
			throw new UnsupportedTestTargetException("No UFG Results found for Test Target:" + target.toString());
		
		default:
			throw new UnsupportedTestTargetException(target.device.deviceType + " is not supported");
		
		}
		
		
	}

}
