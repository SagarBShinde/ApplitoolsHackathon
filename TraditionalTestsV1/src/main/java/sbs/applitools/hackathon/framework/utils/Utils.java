package sbs.applitools.hackathon.framework.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Utils {
	
	
	
	public static String StreamToString (InputStream io) {
		
	return new BufferedReader(new InputStreamReader(io, StandardCharsets.UTF_8))
			      .lines()
			      .collect(Collectors.joining("\n"));
		
	}
	
	public static String readFile (String fileLoc) throws FileNotFoundException {
		
		InputStream io = new FileInputStream(fileLoc);
		return StreamToString(io);
	}

}
