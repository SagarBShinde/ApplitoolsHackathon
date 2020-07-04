package sbs.ufg.hackathon.modern.v1.tests.productFilter;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BrandsFilter {
	
	@FindBy(how = How.ID , using = "LI____133")
	private WebElement adibasSection;
	
	@FindBy(how = How.ID , using = "LI____138")
	private WebElement mikeySection;
	
	@FindBy(how = How.ID , using = "LI____143")
	private WebElement bansSection;
	
	@FindBy(how = How.ID , using = "LI____148")
	private WebElement overAmourSection;
	
	@FindBy(how = How.ID , using = "LI____153")
	private WebElement ImBalanceSection;
	
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
