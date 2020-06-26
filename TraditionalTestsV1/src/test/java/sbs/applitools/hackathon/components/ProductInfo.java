package sbs.applitools.hackathon.components;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.applitools.hackathon.framework.basePage.BaseComponent;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.setup.TestTarget;

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
	
	public Map<String,String> checkProductId(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.productId, "productId");
	
	}
	
	public Map<String,String> checkProductDescription(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.productDescription, "productDescription");
	
	}
	
	public Map<String,String> checkReviewCount(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.reviewCount, "reviewCount");
	
	}
	
	public Map<String,String> checkreviewstart_1(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.reviewstart_1, "reviewstart_1");
	
	}
	
	public Map<String,String> checkreviewstart_2(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.reviewstart_2, "reviewstart_2");
	
	}
	
	public Map<String,String> checkReviewstart_3(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.reviewstart_3, "reviewstart_3");
	
	}
	
	public Map<String,String> checkReviewstart_4(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.reviewstart_4, "reviewstart_4");
	
	}
	
	public Map<String,String> checkReviewstart_5(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.reviewstart_5, "reviewstart_5");
	
	}
	
	
	

}
