package sbs.ufg.hackathon.traditional.v2.tests.productFilter;

import sbs.ufg.hackathon.traditional.v2.framework.basePage.BaseComponent;

public abstract class ProductFilter extends BaseComponent {
	
	public abstract void selectFilterOption(String filterOption) throws Exception;
	public abstract int getMatchCount(String filterOption) throws Exception;

}
