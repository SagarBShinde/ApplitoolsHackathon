package sbs.ufg.hackathon.modern.v2.framework.basePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
	
	private static final Logger LOG = LogManager.getLogger(BasePage.class);
	protected WebDriver driver;
	
	public abstract void wait_til_load();
	
	

}
