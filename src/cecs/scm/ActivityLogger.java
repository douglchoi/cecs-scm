package cecs.scm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * AUTHORS:
 * 1. Douglas Choi 		- douglchoi@gmail.com
 * 2. Imanuel Kurniawan - imanuel.k09@hotmail.com
 * 3. Vincent Cheong 	- vincentkcheong@gmail.com
 * 
 * FILE DESCRIPTION:
 * Logs the activity to the manifest file
 */
public class ActivityLogger {
	
	public static String ACTIVITY_FOLDER_NAME = "activity";
	public static String MANIFEST_FILENAME = "manifest";
	
	private File manifest;
	
	/**
	 * Creates an activity folder in the root repository folder with a 
	 * manifest file with the datetime in the file name
	 * @param repoRootFolder
	 */
	public ActivityLogger(String repoRootFolder) {
		// make activity folder
		File activityFolder = new File(repoRootFolder + File.separator + ACTIVITY_FOLDER_NAME);
		activityFolder.mkdirs();
		
		// make manifest
		SimpleDateFormat fmt = new SimpleDateFormat("YYYYMMdd_hhmm");
		String manifestFullName = MANIFEST_FILENAME + "_" + fmt.format(new Date());
		
		manifest = new File(activityFolder + File.separator + manifestFullName);
		
		System.out.println("Manifest file created: " + manifest);
		
		writeLine(manifest.getName());
		writeLine("Vix-1");
		
	}

	/**
	 * Write a line in the manifest file
	 * @param line
	 */
	public void writeLine(String line) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(manifest, true));
			writer.write(line + System.lineSeparator());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
