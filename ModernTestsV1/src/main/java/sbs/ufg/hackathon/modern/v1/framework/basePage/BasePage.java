package sbs.ufg.hackathon.modern.v1.framework.basePage;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sbs.ufg.hackathon.modern.v1.framework.excptions.VisualAttributeException;
import sbs.ufg.hackathon.modern.v1.framework.setup.TestTarget;
import sbs.ufg.hackathon.modern.v1.framework.utils.VisualAttribute;

public abstract class BasePage {
	
	private static final Logger LOG = LogManager.getLogger(BasePage.class);
	protected WebDriver driver;
	
	public abstract void wait_til_load();
	
	

}
