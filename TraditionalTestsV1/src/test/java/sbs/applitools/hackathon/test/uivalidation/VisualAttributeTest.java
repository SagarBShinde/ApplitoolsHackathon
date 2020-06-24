package sbs.applitools.hackathon.test.uivalidation;

import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import sbs.applitools.hackathon.framework.baseTest.BaseTest;
import sbs.applitools.hackathon.framework.dataProvider.TestTargetList;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.setup.TestTarget;
import sbs.applitools.hackathon.pages.HomePage;

@Test
@TestTargetList({"Mobile_chrome"})
public class VisualAttributeTest extends BaseTest {

	 public VisualAttributeTest(TestTarget target) {
		    this.testTarget = target;
		 }
		    
	public VisualAttributeTest() {
		    	
		}
	
	public void validateFilterBtn() throws FrameworkException {
		this.report.write("Task1: Validating Filter Button field");
		SoftAssert softAssertion= new SoftAssert();
		HomePage homePage = new HomePage(this.getDriver());
		this.testTarget.visual_attribute_dir = ".//config/visual_attributes//laptop_chrome";
		System.out.println(homePage.filterButtons.checkfilterBtn("homePage", this.testTarget));
		Map<String, String> compareResult = homePage.filterButtons.checkfilterBtn("homePage", this.testTarget);
		Iterator<String> itr = compareResult.keySet().iterator();
		while(itr.hasNext()) {
			String result = itr.next();
			this.getMessage(result);
			softAssertion.assertEquals(compareResult.get(result), "Passed");
			
		}
		softAssertion.assertAll();
		
	}

	private void getMessage(String result) {
		
		
	}
	
	
}
