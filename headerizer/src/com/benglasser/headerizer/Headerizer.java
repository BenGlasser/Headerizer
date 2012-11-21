/**
 * @author  Copyright (c) 2012 Ben Glasser
 * 
 */

package com.benglasser.headerizer;

import java.io.*;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

public class Headerizer {

	private static final int MISSING_ARGS_CODE = 1;
	private static final int MISSING_FILE_CODE = 2;
	private static final String MISSING_ARGS = "missing one or more parameters";
	private static final String MISSING_FILE = "specified file does not exist: ";

	private static String ext = null;
	private static String filePath = null;
	private static String header = null;
	private static boolean recursive = false;
	private static ArrayList<File> fileList = null;

	/**
	 * @param args
	 *            headerizer.java -r <file extention> <directory> <header>
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parse(args);
		File rootFile = new File(filePath);
		if (!fileExists(rootFile)) {
			System.setErr(System.out.printf(MISSING_FILE));
			System.exit(MISSING_FILE_CODE);
		} else {
			insertHeader(rootFile);
		}

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
				fileList = new ArrayList<File>(FileUtils.listFiles(file,
						new String[] { ext }, recursive));
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
			FileUtils.copyFile(file, tmp);//(tmp, FileUtils.readFileToString(file));
			FileUtils.writeStringToFile(file, header);
			FileUtils.writeStringToFile(file, FileUtils.readFileToString(tmp), true);

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	private static void parse(String[] args) {
		if (args[0].contains("-") && !args[0].contains(".")) {
			setFlags(args[0]);
			setArgs(new String[] { args[1], args[2], args[3] });
		} else
			setArgs(new String[] { args[0], args[1], args[2] });
	}

	private static void setFlags(String flags) {
		if (flags.contains("r"))
			recursive = true;
	}

	private static void setArgs(String[] args) {
		if (args[0].isEmpty() || args[1].isEmpty()) {
			System.setErr(System.out.printf(MISSING_ARGS));
			System.exit(MISSING_ARGS_CODE);
		}
		ext = args[0];
		filePath = args[1];
		header = args[2] + "\n";
	}

}
