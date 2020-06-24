package sbs.applitools.hackathon.components;

import org.openqa.selenium.WebDriver;

import sbs.applitools.hackathon.framework.basePage.BaseComponent;
import sbs.applitools.hackathon.productFilter.BrandsFilter;
import sbs.applitools.hackathon.productFilter.ColorFilter;
import sbs.applitools.hackathon.productFilter.PriceFilter;
import sbs.applitools.hackathon.productFilter.TypeFilter;

public class FilterSection extends BaseComponent {
	
	public FilterSection(WebDriver driver) {
		this.setDriver(driver);
	}

	ColorFilter colorFilter;
	PriceFilter priceFilter;
	BrandsFilter brandFilter;
	TypeFilter typeFilter;
	
	@Override
	public void wait_till_load() {
		// TODO Auto-generated method stub
		
	}
	
	
	
		

}
