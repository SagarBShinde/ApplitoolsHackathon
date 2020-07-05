package sbs.ufg.hackathon.traditional.v2.tests.productFilter;

import sbs.ufg.hackathon.traditional.v2.framework.basePage.BaseComponent;
import sbs.ufg.hackathon.traditional.v2.framework.excptions.FrameworkException;

public abstract class ProductFilter extends BaseComponent {
	
	public abstract void selectFilterOption(String filterOption) throws FrameworkException;
	public abstract int getExpectedMatchCount(String filterOption) throws FrameworkException;

}
