package sbs.ufg.hackathon.traditional.v2.tests.productFilter;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TypeFilter {
	
	@FindBy(how = How.ID , using = "LI____78")
	private WebElement soccerSection;
	
	@FindBy(how = How.ID , using = "LI____83")
	private WebElement basketballSection;
	
	@FindBy(how = How.ID , using = "LI____88")
	private WebElement runningSection;
	
	@FindBy(how = How.ID , using = "LI____93")
	private WebElement trainingSection;
	
	
	
	
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
