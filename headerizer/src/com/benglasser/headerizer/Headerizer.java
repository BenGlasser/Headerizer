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

	private static String ext = null;
	private static String filePath = null;
	private static String header = null;
	private static boolean recursive = false;
	private static ArrayList<File> fileList = null;
	private static JSAP jsap;
	private static JSAPResult config;

	/**
	 * @param args
	 *            headerizer.java -r <file extention> <directory> <header>
	 */
	public static void main(String[] args) {
		CLIP cli = new CLIP(args);
		// buildJsap(args);
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

	private static void buildJsap(String[] args) {
		jsap = new JSAP();
		UnflaggedOption fileType = new UnflaggedOption("fileType")
				.setStringParser(JSAP.STRING_PARSER).setDefault("txt") 
				.setRequired(true).setGreedy(true);

		UnflaggedOption directory = new UnflaggedOption("directory")
				.setStringParser(JSAP.STRING_PARSER).setDefault("./") 
				.setRequired(true).setGreedy(false);

		UnflaggedOption header = new UnflaggedOption("header")
				.setStringParser(JSAP.STRING_PARSER)
				.setDefault("//  Default Header") 
				.setRequired(true).setGreedy(false);

		Switch recursive = new Switch("recursive").setShortFlag('r')
				.setLongFlag("recursive");
		try {
			jsap.registerParameter(recursive);
			jsap.registerParameter(directory);
			jsap.registerParameter(header);
			jsap.registerParameter(fileType);
			config = jsap.parse(args);
		} catch (Exception e) {
			System.err.println();
			System.err.println("Usage: java " + Headerizer.class.getName());
			System.err.println("                " + jsap.getUsage());
			System.err.println();
			// show full help as well
			System.err.println(jsap.getHelp());
			System.exit(1);
		}
		System.out.println(jsap.getUsage());
		System.out.println(jsap.getHelp());

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
			FileUtils.copyFile(file, tmp);
			FileUtils.writeStringToFile(file, header);
			FileUtils.writeStringToFile(file, FileUtils.readFileToString(tmp),
					true);

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
		header = args[2] + "\n\r";
	}

}
