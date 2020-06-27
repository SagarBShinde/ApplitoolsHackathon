package sbs.applitools.hackathon.framework.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sbs.applitools.hackathon.framework.basePage.BasePage;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;

public class Utils {
	
	private static final Logger LOG = LogManager.getLogger(Utils.class);
	
	public static String StreamToString (InputStream io) {
		
	return new BufferedReader(new InputStreamReader(io, StandardCharsets.UTF_8))
			      .lines()
			      .collect(Collectors.joining("\n"));
		
	}
	
	public static String readFile (String fileLoc) throws FileNotFoundException {
		
		InputStream io = new FileInputStream(fileLoc);
		return StreamToString(io);
	}
	
	public static String mapToString(Map map) {
		return StringUtils.join(map);
	}
	
	public static File createFile(String filePath) throws FrameworkException {
		
		try {
		      File file = new File(filePath);
		      if (file.createNewFile()) {
		        LOG.info("File created: " + file.getName());
		      } else {
		    	  LOG.info("File already exists.");
		      }
		      return file;
		    } catch (IOException e) {
		      throw new FrameworkException("Output file could not be created");
		    }
		
		
		
		
	}

	public static Object deriveStatus(ArrayList<String> statusList) {
		String status = "";
		String reason = "";
		if (statusList.isEmpty()) {
			return "NA" + "Reason: Status Array is Empty";
		}
		
		Iterator<String> itr = statusList.iterator();
		
		while(itr.hasNext()) {
			 String stat = itr.next();
			 if (stat.equalsIgnoreCase("Pass")){
				 if (status.isEmpty()) {
					 status = "Pass";
				 }
			 }else {
				 status = "Fail";
				 reason = reason + stat.substring(4);
				 
			 }	
		}	
		if (status.equalsIgnoreCase("Pass")){
			return status;
		}else {
			return status + " Reason:" + reason;
		}
		
	}

}
