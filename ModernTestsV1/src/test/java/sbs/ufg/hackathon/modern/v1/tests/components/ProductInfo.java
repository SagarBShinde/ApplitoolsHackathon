package sbs.ufg.hackathon.modern.v1.tests.components;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sbs.ufg.hackathon.modern.v1.framework.basePage.BaseComponent;
import sbs.ufg.hackathon.modern.v1.framework.excptions.FrameworkException;
import sbs.ufg.hackathon.modern.v1.framework.setup.TestTarget;

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
	
	public Map<String,String> checkProductId(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.productId, "productId");
	
	}
	
	public Map<String,String> checkProductDescription(String pageName, TestTarget target) throws FrameworkException{
		scrollToElement(this.productDescription);
		return this.compareElementVisuals(pageName, target, this.productDescription, "productDescription");
	
	}
	
	public Map<String,String> checkReviewCount(String pageName, TestTarget target) throws FrameworkException{
		scrollToElement(this.reviewCount);
		return this.compareElementVisuals(pageName, target, this.reviewCount, "reviewCount");
	
	}
	
	public Map<String,String> checkReviewstar_1(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.reviewstar_1, "reviewstar_1");
	
	}
	
	public Map<String,String> checkReviewstar_2(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.reviewstar_2, "reviewstar_2");
	
	}
	
	public Map<String,String> checkReviewstar_3(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.reviewstar_3, "reviewstar_3");
	
	}
	
	public Map<String,String> checkReviewstar_4(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.reviewstar_4, "reviewstar_4");
	
	}
	
	public Map<String,String> checkReviewstar_5(String pageName, TestTarget target) throws FrameworkException{
		return this.compareElementVisuals(pageName, target, this.reviewstar_5, "reviewstar_5");
	
	}
	
	
	

}
