package sbs.applitools.hackathon.productFilter;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.setup.TestTarget;

public class ColorFilter extends ProductFilter {
	
	@FindBy(how = How.ID , using = "LI____103")
	private WebElement blackFilterSection;
	
	@FindBy(how = How.ID , using = "LI____108")
	private WebElement whiteFilterSection;
	
	@FindBy(how = How.ID , using = "LI____113")
	private WebElement blueFilterSection;
	
	@FindBy(how = How.ID , using = "LI____118")
	private WebElement greenFilterSection;
	
	@FindBy(how = How.ID , using = "DIV__dropdowndr__123")
	private WebElement yellowFilterSection;
	
	@Override
	public void wait_till_load() {
		waitTilVisible(blackFilterSection);
		
	}
	
	
	
	
	
	public void selectFilterOption(String filterOption) throws FrameworkException {
		String filterId = "colors__"+StringUtils.capitalize(filterOption);
		try {
			getFilterSection(filterOption).findElement(By.id(filterId)).click();
		} catch (Exception e) {
		
			throw new FrameworkException("Could not apply filter:"+ e.getStackTrace());
		}		
	}

	

	public int getMatchCount(String filterOption) throws NumberFormatException, Exception {
		return Integer.parseInt(getFilterSection(filterOption).findElement(By.xpath(".//*[contains(@id, 'SMALL')]")).getText());
	
	}
	
	private WebElement getFilterSection(String color) throws Exception {
		
		switch (color.toLowerCase()) {
		
			case "black":
				return this.blackFilterSection;
			
			case "white":
				return this.whiteFilterSection;
			
			case "green":
				return this.greenFilterSection;
			
			case "yellow":
				return this.yellowFilterSection;
			
			case "blue":
				return this.blueFilterSection;
			
			default:
				throw new Exception("Invalid option specified for the filter ");
		}
		
	}

	public Map<String,String> checkBlackFilterSection(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.blackFilterSection, "blackFilterSection");
	
	}
	
	public Map<String,String> checkWhiteFilterSection(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.whiteFilterSection, "whiteFilterSection");
	
	}
	
	public Map<String,String> checkGreenFilterSection(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.greenFilterSection, "greenFilterSection");
	
	}
	
	public Map<String,String> checkYellowFilterSection(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.yellowFilterSection, "yellowFilterSection");
	
	}
	
	public Map<String,String> checkBlueFilterSection(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.blueFilterSection, "blueFilterSection");
	
	}


	

}
