/**
 * @author  Copyright (c) 2012 Ben Glasser
 * 
 */

package com.benglasser.headerizer;

public class Headerizer {


	private static final int MISSING_ARGS_CODE = 1;
	private static String ext = null;
	private static String header = null;
	private static boolean recursive = false;
	private static final String MISSING_ARGS = "missing one or more parameters";
	/**
	 * @param args
	 * headerizer.java -r <file extention> <header>
	 */	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parse(args);

	}
	private static void parse(String[] args){
		if (args[0].contains("-") && !args[0].contains(".")){ 
			setFlags(args[0]);
			setArgs(new String[]{args[1], args[2]});
		}
		else 
			setArgs(new String[]{args[0], args[1]});
	}
	private static void setFlags(String flags){
		if (flags.contains("r")) recursive = true;
	}
	private static void setArgs(String[] args){
		if (args[0].isEmpty() || args[1].isEmpty()){
			System.setErr(System.out.printf(MISSING_ARGS));
			System.exit(MISSING_ARGS_CODE);
		}
		ext = args[0];
		header = args[1];
	}

}
