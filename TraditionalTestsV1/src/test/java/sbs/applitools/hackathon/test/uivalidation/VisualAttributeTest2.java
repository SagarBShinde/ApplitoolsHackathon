package sbs.applitools.hackathon.test.uivalidation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.bytebuddy.asm.Advice.This;
import sbs.applitools.hackathon.framework.baseTest.BaseTest;
import sbs.applitools.hackathon.framework.dataProvider.TestTargetList;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.framework.utils.Utils;
import sbs.applitools.hackathon.pages.HomePage;

@Test
@TestTargetList({"Laptop_all"})
public class VisualAttributeTest2 extends BaseTest {

	 public VisualAttributeTest2(TestTarget target) {
		    this.testTarget = target;
		 }
		    
	public VisualAttributeTest2() {
	}
	
	
	@Test(description = "Validate Filter button on the home page")
	public void validateFilterBtn() throws FrameworkException {
		System.out.println("*********************Starting validation test*******************");
		SoftAssert softAssertion= new SoftAssert();
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate filter button, DOM Id:",homePage.filterButtons.getLocator("filterBtn"),this.testTarget );
		
		Map<String, String> compareResult = homePage.filterButtons.checkfilterBtn("homePage", this.testTarget);
		Iterator<String> itr = compareResult.keySet().iterator();
		
		ArrayList<String> ui_validations =  new ArrayList<String>();
		
		while(itr.hasNext()) {
			String result = itr.next();
			softAssertion.assertEquals(compareResult.get(result), "Pass");
			ui_validations.add(compareResult.get(result));
		}
		reportRec.append("Status:"+ Utils.deriveStatus(ui_validations));
		System.out.println(reportRec.toString());
		report.write(reportRec.toString());
		softAssertion.assertAll();	
		System.out.println("*********************Finishing validation test*******************");
	}
	
	@Test(description = "Validate Reset button on the home page")
	public void validateResetBtn() throws FrameworkException {
		System.out.println("*********************Starting reset test*******************");
		SoftAssert softAssertion= new SoftAssert();
		HomePage homePage = new HomePage(this.getDriver());
		StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Reset button, DOM Id:",homePage.filterButtons.getLocator("resetBtn"),this.testTarget );
		
		Map<String, String> compareResult = homePage.filterButtons.checkResetBtn("homePage", this.testTarget);
		Iterator<String> itr = compareResult.keySet().iterator();
		
		ArrayList<String> ui_validations =  new ArrayList<String>();
		
		while(itr.hasNext()) {
			String result = itr.next();
			softAssertion.assertEquals(compareResult.get(result), "Pass");
			ui_validations.add(compareResult.get(result));
		}
		reportRec.append("Status:"+ Utils.deriveStatus(ui_validations));
		report.write(reportRec.toString());
		softAssertion.assertAll();
		System.out.println(reportRec.toString());
		System.out.println("*********************Finishing reset test*******************");
	}	
	
}
