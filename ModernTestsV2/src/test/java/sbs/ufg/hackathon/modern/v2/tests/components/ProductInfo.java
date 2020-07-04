package sbs.ufg.hackathon.modern.v2.tests.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.ufg.hackathon.modern.v2.framework.basePage.BaseComponent;

public class ProductInfo extends BaseComponent {
	
	public ProductInfo(WebDriver driver) {
		this.setDriver(driver);
	}
	
	
	@FindBy(how = How.ID , using = "DIV__collg__74") 
	private WebElement ProductInfoContainer;
	
	@FindBy(how = How.ID , using = "SMALL____84") 
	private WebElement productId;
	
	@FindBy(how = How.ID , using = "BR____85") 
	private WebElement productDescription;
	
	@FindBy(how = How.ID , using = "EM____82") 
	private WebElement reviewCount;
	
	@FindBy(how = How.ID , using = "I__iconstarvo__77") 
	private WebElement reviewstar_1;
	
	@FindBy(how = How.ID , using = "I__iconstarvo__78") 
	private WebElement reviewstar_2;
	
	@FindBy(how = How.ID , using = "I__iconstarvo__79") 
	private WebElement reviewstar_3;
	
	@FindBy(how = How.ID , using = "I__iconstarvo__80") 
	private WebElement reviewstar_4;
	
	@FindBy(how = How.ID , using = "I__iconstar__81") 
	private WebElement reviewstar_5;

	@Override
	public void wait_till_load() {
		waitTilVisible(this.productDescription);
		
	}
	
	

}
