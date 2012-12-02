package com.benglasser.headerizer;

import com.martiansoftware.jsap.*;

public class CLIP extends JSAP {
	public static final String FILE_TYPE = "fileType";
	public static final String HEADER = "header";
	public static final String DIRECTORY = "directory";
	public static final String HELP = "help";
	public static final String RECURSIVE = "recursive";
	public static final String VERBOSE = "verbose";
	
	private JSAP jsap;
	private JSAPResult config;

	// Command Line Interface Parser
	CLIP(String[] args) {
		jsap = new JSAP();
		UnflaggedOption fileType = new UnflaggedOption(FILE_TYPE)
				.setStringParser(JSAP.STRING_PARSER).setDefault("txt")
				.setRequired(true).setGreedy(true);
		fileType.setHelp("file extensions of files which are to be Headerized");

		UnflaggedOption directory = new UnflaggedOption(DIRECTORY)
		// set default file type to txt
				.setStringParser(JSAP.STRING_PARSER).setDefault("./") 
				.setRequired(true).setGreedy(false);
		directory.setHelp("Name of directory or file which is to be Headerized");

		UnflaggedOption header = new UnflaggedOption(HEADER)
				.setStringParser(JSAP.STRING_PARSER)
				// set default file type to txt
				.setDefault("//  Default Header") 
				.setRequired(true).setGreedy(false);
		header.setHelp("This is the intended header to " +
				"be inserted into the specified files");

		Switch recursive = new Switch(RECURSIVE).setShortFlag('r')
				.setLongFlag("recursive");
		recursive.setHelp("tell Headerizer whether or not to recursively " +
				"search subdirectories for matching files");
		Switch help = new Switch(HELP).setShortFlag('h').setLongFlag("help");
		help.setHelp("displays this message");

		Switch verbose = new Switch("verbose").setShortFlag('v').setLongFlag(
				"verbose");
		verbose.setHelp("Requests verbose output");

		try {
			jsap.registerParameter(recursive);
			jsap.registerParameter(help);
			jsap.registerParameter(verbose);
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
		if (config.getBoolean(HELP)) System.out.println(jsap.getHelp());
		//System.out.println(jsap.getUsage());
		//System.out.println(jsap.getHelp());

	}
	public JSAPResult Config(){
		return config;
	}
}
