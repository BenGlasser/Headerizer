/**
 * @author  Copyright (c) 2012 Ben Glasser
 * JSAP help http://www.martiansoftware.com/jsap/doc/
 * 
 */

package com.benglasser.headerizer;

import com.martiansoftware.jsap.*;
import java.io.*;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

public class Headerizer {

	private static final int MISSING_ARGS_CODE = 1;
	private static final int MISSING_FILE_CODE = 2;
	private static final String MISSING_ARGS = "missing one or more parameters";
	private static final String MISSING_FILE = "specified file does not exist: ";
	private static  CLIP cli;
	
	/*private static String ext = null;
	private static String filePath = null;
	private static String header = null;
	private static boolean recursive = false;
	private static ArrayList<File> fileList = null;
	private static JSAP jsap;
	private static JSAPResult config;
*/
	/**
	 * @param args
	 *            headerizer.java -r <file extention> <directory> <header>
	 */
	public static void main(String[] args) {
		cli = new CLIP(args);
		insertHeader(new File(cli.Config().getString(CLIP.DIRECTORY)));
		
		/*
		 * if (args.length < 3) { System.err.println(MISSING_ARGS);
		 * System.exit(1); }
		 * 
		 * // TODO Auto-generated method stub parse(args); File rootFile = new
		 * File(filePath); if (!fileExists(rootFile)) {
		 * System.setErr(System.out.printf(MISSING_FILE));
		 * System.exit(MISSING_FILE_CODE); } else { insertHeader(rootFile); }
		 */

	}


	private static boolean fileExists(File testFile) {
		// FIXME cheap error handling here...
		if (!testFile.exists()) {
			System.setErr(System.out.printf(MISSING_FILE + testFile.toString()));
			System.exit(MISSING_FILE_CODE);
		}
		return true;
	}

	private static void insertHeader(File file) {

		if (file.isDirectory()) {

			try {
				ArrayList<File> fileList = new ArrayList<File>(FileUtils.listFiles(file,
						cli.Config().getStringArray(CLIP.FILE_TYPE), cli.Config().getBoolean(CLIP.RECURSIVE)));
				for (File i : fileList) {
					prependToFile(i);
				}
			} catch (Exception e) {
				// TODO handle exception here.
				e.printStackTrace();
			}
		} else if (file.isFile()) {
			prependToFile(file);
		}
	}

	private static void prependToFile(File file) {
		try {
			File tmp = File.createTempFile("tmp", null);
			FileUtils.copyFile(file, tmp);
			FileUtils.writeStringToFile(file, cli.Config().getString(CLIP.HEADER) + "\n\r");
			FileUtils.writeStringToFile(file, FileUtils.readFileToString(tmp),
					true);

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

}
