package sbs.ufg.hackathon.modern.v1.framework.setup;

public class Browser {

	public String browserName;
	public String version;
	public ViewPort size;
	private String browserDriverLoc;
	
	
	
	
	public String getBrowserDriverLoc() {
		return browserDriverLoc;
	}
	public void setBrowserDriverLoc(String browserDriverLoc) {
		this.browserDriverLoc = browserDriverLoc;
	}
	
	@Override
	public String toString() {
		 return browserName + "::" + version;
		
	}
	
	
}
