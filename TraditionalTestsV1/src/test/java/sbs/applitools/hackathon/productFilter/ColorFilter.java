package sbs.applitools.hackathon.productFilter;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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




	

}
