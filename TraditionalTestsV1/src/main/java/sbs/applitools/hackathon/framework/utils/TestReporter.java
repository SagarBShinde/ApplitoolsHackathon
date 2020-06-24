package sbs.applitools.hackathon.framework.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sbs.applitools.hackathon.framework.constants.FrameworkConstants;
import sbs.applitools.hackathon.framework.excptions.FrameworkException;
import sbs.applitools.hackathon.framework.excptions.ReporterException;

public class TestReporter {
	
	private static final Logger LOG = LogManager.getLogger(TestReporter.class);
	
	private File reportFile;
	private BufferedWriter writer;
	
	public TestReporter() throws FrameworkException {
		
		DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		String fileName = FrameworkConstants.OUTPUT_DIR + "//report_"+ df.format(new Date())+ ".txt";
		LOG.debug("Output file created:"+ fileName);
		this.reportFile = Utils.createFile(fileName);
		
	}
	
	public void open() throws ReporterException {
		
		 try {
			this.writer = new BufferedWriter(new FileWriter(this.reportFile));
		} catch (IOException e) {
			throw new ReporterException(" Could not open writer for the reporter:"+ e.getStackTrace());

		}
	}
	
	public void write(String msg) throws ReporterException{
		
		 try {
			this.writer.append("\n");
			this.writer.append(msg);
		} catch (IOException e) {
			throw new ReporterException(" Could not write to the reporter:"+ e.getStackTrace());
		}
		 
	}
	
	public void close() throws ReporterException{
		
		 try {
			this.writer.close();
		} catch (IOException e) {
			throw new ReporterException(" Could not close the reporter:"+ e.getStackTrace());
			
		}
		 
	}

}
