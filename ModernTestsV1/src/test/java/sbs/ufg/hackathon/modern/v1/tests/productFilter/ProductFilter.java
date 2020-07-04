package sbs.ufg.hackathon.modern.v1.tests.productFilter;

import sbs.ufg.hackathon.modern.v1.framework.basePage.BaseComponent;

public abstract class ProductFilter extends BaseComponent {
	
	public abstract void selectFilterOption(String filterOption) throws Exception;
	public abstract int getMatchCount(String filterOption) throws Exception;

}
