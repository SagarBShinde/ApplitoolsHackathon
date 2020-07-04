package sbs.ufg.hackathon.modern.v1.tests.productFilter;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PriceFilter {
	
	@FindBy(how = How.ID , using = "LI____163")
	private WebElement zeroTo50Section;
	
	@FindBy(how = How.ID , using = "LI____168")
	private WebElement fiftyTo100Section;
	
	@FindBy(how = How.ID , using = "LI____173")
	private WebElement hundredTo150Section;
	
	@FindBy(how = How.ID , using = "LI____178")
	private WebElement onefiftyTo200Section;
	
	
	public void selectFilterOption(String filterOption) throws Exception {
		throw  new  Exception("Functionality not implemented");	
	}

	

	public int getMatchCount(String filterOption) throws NumberFormatException, Exception {
		throw  new  Exception("Functionality not implemented");	
	
	}
	
	private WebElement getFilterSection(String color) throws Exception {
		
		throw  new  Exception("Functionality not implemented");
		
	}
	

}
