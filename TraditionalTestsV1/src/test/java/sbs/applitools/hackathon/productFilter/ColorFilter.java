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
	private WebElement blackFiilterSection;
	
	@FindBy(how = How.ID , using = "LI____108")
	private WebElement whiteFiilterSection;
	
	@FindBy(how = How.ID , using = "LI____113")
	private WebElement blueFiilterSection;
	
	@FindBy(how = How.ID , using = "LI____118")
	private WebElement greenFiilterSection;
	
	@FindBy(how = How.ID , using = "DIV__dropdowndr__123")
	private WebElement yellowFiilterSection;
	
	@Override
	public void wait_till_load() {
		waitTilVisible(blackFiilterSection);
		
	}
	
	
	
	
	
	public void selectFilterOption(String filterOption) throws Exception {
		String filterId = "colors__"+StringUtils.capitalize(filterOption);
		getFilterSection(filterOption).findElement(By.id(filterId)).click();		
	}

	

	public int getMatchCount(String filterOption) throws NumberFormatException, Exception {
		return Integer.parseInt(getFilterSection(filterOption).findElement(By.xpath(".//*[contains(@id, 'SMALL')]")).getText());
	
	}
	
	private WebElement getFilterSection(String color) throws Exception {
		
		switch (color.toLowerCase()) {
		
			case "black":
				return this.blackFiilterSection;
			
			case "white":
				return this.whiteFiilterSection;
			
			case "green":
				return this.greenFiilterSection;
			
			case "yellow":
				return this.yellowFiilterSection;
			
			case "blue":
				return this.blueFiilterSection;
			
			default:
				throw new Exception("Invalid option specified for the filter ");
		}
		
	}

	public Map<String,String> checkBlackFilterSection(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.blackFiilterSection, "blackFiilterSection");
	
	}
	
	public Map<String,String> checkWhiteFilterSection(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.whiteFiilterSection, "whiteFiilterSection");
	
	}
	
	public Map<String,String> checkGreenFilterSection(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.greenFiilterSection, "greenFiilterSection");
	
	}
	
	public Map<String,String> checkYellowFilterSection(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.yellowFiilterSection, "yellowFiilterSection");
	
	}
	
	public Map<String,String> checkBlueFilterSection(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.blueFiilterSection, "blueFiilterSection");
	
	}


	

}
