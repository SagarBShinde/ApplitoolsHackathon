package sbs.ufg.hackathon.traditional.v2.tests.components;

import org.openqa.selenium.WebDriver;

import sbs.ufg.hackathon.traditional.v2.framework.basePage.BaseComponent;
import sbs.ufg.hackathon.traditional.v2.tests.productFilter.BrandsFilter;
import sbs.ufg.hackathon.traditional.v2.tests.productFilter.ColorFilter;
import sbs.ufg.hackathon.traditional.v2.tests.productFilter.PriceFilter;
import sbs.ufg.hackathon.traditional.v2.tests.productFilter.TypeFilter;

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
		colorFilter.wait_till_load();
		
	}
	
	
	
		

}
