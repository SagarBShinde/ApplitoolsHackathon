package sbs.ufg.hackathon.traditional.v1.tests.productFilter;

import sbs.ufg.hackathon.traditional.v1.framework.basePage.BaseComponent;
import sbs.ufg.hackathon.traditional.v1.framework.excptions.FrameworkException;

public abstract class ProductFilter extends BaseComponent {
	
	public abstract void selectFilterOption(String filterOption) throws FrameworkException;
	public abstract int getExpectedMatchCount(String filterOption) throws FrameworkException;

}
