package sbs.applitools.hackathon.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import sbs.applitools.hackathon.framework.excptions.FrameworkException;

public class propertyHandler {
	
	private static propertyHandler instance = null;
    private Properties properties;


    protected propertyHandler() throws FrameworkException{
    	try {
    		properties = new Properties();
    		properties.load(new FileInputStream(System.getProperty("user.dir")+ "//config//app.properties"));
    	} catch (IOException e) {
    		throw new FrameworkException("Could not load properties file:" + e.getStackTrace());
    	}
    }

    public static propertyHandler getInstance() throws FrameworkException {
        if(instance == null) {
            instance = new propertyHandler();
        }
        return instance;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }


}
