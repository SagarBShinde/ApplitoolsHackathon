package sbs.applitools.hackathon.productFilter;

import sbs.applitools.hackathon.framework.basePage.BaseComponent;

public abstract class ProductFilter extends BaseComponent {
	
	public abstract void selectFilterOption(String filterOption) throws Exception;
	public abstract int getMatchCount(String filterOption) throws Exception;

}
