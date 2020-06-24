package sbs.applitools.hackathon.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.applitools.hackathon.framework.basePage.BaseComponent;

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
	private WebElement reviewstart_1;
	
	@FindBy(how = How.ID , using = "I__iconstarvo__78") 
	private WebElement reviewstart_2;
	
	@FindBy(how = How.ID , using = "I__iconstarvo__79") 
	private WebElement reviewstart_3;
	
	@FindBy(how = How.ID , using = "I__iconstarvo__80") 
	private WebElement reviewstart_4;
	
	@FindBy(how = How.ID , using = "I__iconstarvo__81") 
	private WebElement reviewstart_5;

	@Override
	public void wait_till_load() {
		waitTilVisible(this.productDescription);
		
	}
	
	
	
	

}
