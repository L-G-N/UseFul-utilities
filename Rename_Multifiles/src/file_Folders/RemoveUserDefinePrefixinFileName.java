package file_Folders;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RemoveUserDefinePrefixinFileName {
	
	final static File folder = new File("E:\\Songs");	
	static String fncondition = null;
	static String trimCondtion = null;
	static String line = null;
	static String fname = null;
	static String usPrefix = null;
	
	public static void main (String[] args) throws IOException{
		System.out.println("main starts");
		System.out.println("Enter the string need to be removed from file name");
		Scanner scn = new Scanner(System.in);
		usPrefix = scn.nextLine();
		rename(folder);
		System.out.println("main ends");
	}
	
	public static void rename(File folder) throws IOException{
		
		//checking directory 
		for (File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            rename(fileEntry);
	        } else {
	        	fname = fileEntry.getName();
	        	//prefix checking for files in sub folders
	        	if(fname.startsWith(usPrefix)){
		        	line = "cd "+'"'+'"'+folder.toString()+'"'+'"'+'"'+";";
		        	System.out.println(fileEntry.getName());
		        	/*if((fileEntry.getName().contains("("))||(fileEntry.getName().contains(")"))||(fileEntry.getName().contains("  "))||(fileEntry.getName().contains("["))||(fileEntry.getName().contains("]"))){
		        		line = folder.toString()+"\\";
			        	if(fileEntry.getName().contains("(")){
			    			String symb = "(";
			    			renameItem(fileEntry, symb);
			            	call();}
			        	else if(fileEntry.getName().contains(")")){
			    			String symb =")";
			    			renameItem(fileEntry, symb);
			    			call();}
			        	else if(fileEntry.getName().contains("  ")){
			    			String symb ="  ";
			    			renameItem(fileEntry, symb);
			    			call();}
			        	else if(fileEntry.getName().contains("[")){
			    			String symb ="[";
			    			renameItem(fileEntry, symb);
			    			call();}
			        	else if(fileEntry.getName().contains("]")){
			    			String symb ="]";
			    			renameItem(fileEntry, symb);
			    			call();}
		        	}*/
		        	if((fileEntry.getName().contains(usPrefix))){
		        		line = folder.toString()+"\\";
		        		nameCheck(fileEntry);
		        	}
		        	if(fileEntry.getName().contains(usPrefix)){
			    			String symb = usPrefix;
			    			renameItem(fileEntry, symb);
			            	call();
		        	}
	        	}
	        }
	    }
	}
	
	//This method will check the prefix letter and send the letter need to removed
	public static void nameCheck(File fileEntry) throws IOException{
		fname = fileEntry.getName();
		if(fname.startsWith(usPrefix))
    		run(line, usPrefix, fname);
    	
    	else{
    		return;
    	}
		
	}
	
	//This method will create and execute the command in powershell to rename the file
	public static void run(String line, String letter, String fname) throws IOException{
		System.out.println(fname);
		
		trimCondtion = "$o = "+'"'+'"'+'"'+fname+'"'+'"'+'"'+"; $n = $o.TrimStart("+'"'+'"'+'"'+letter+'"'+'"'+'"'+");";
		fncondition = " Dir | Rename-Item –NewName { $_.name –replace $o,$n }";
		//System.out.println(trimCondtion);
		//System.out.println(fncondition);
		System.out.println("powershell.exe "+line + trimCondtion + fncondition);
		String[] command = {"powershell.exe ", line, trimCondtion, fncondition};
    	
    	Process powerShellProcess = Runtime.getRuntime().exec(command);
    	powerShellProcess.getOutputStream().close();
    	
		 BufferedReader stderr = new BufferedReader(new InputStreamReader(
			    powerShellProcess.getErrorStream()));
			  while ((line = stderr.readLine()) != null) {
				System.out.println("Error:");
		   //System.out.println(line);
		  }
		  stderr.close();
	}

	//This method will create and execute the command in powershell to rename the file(this method for those files contains "  " ()[] in name)
	public static void renameItem(File fileEntry,String symb) throws IOException{
		String newname1;
		System.out.println(fileEntry.getName());
		fname = fileEntry.getName();
		
		newname1 = fname.replace(symb, "");
		System.out.println("powershell.exe "+"Rename-Item " +'"'+'"'+'"'+line+fname+'"'+'"'+'"'+" –NewName " +'"'+'"'+'"'+newname1+'"'+'"'+'"');
		String[] command = {"powershell.exe "," Rename-Item " +'"'+'"'+'"'+line+fname+'"'+'"'+'"'+" –NewName " +'"'+'"'+'"'+newname1+'"'+'"'+'"'};
    	Process powerShellProcess = Runtime.getRuntime().exec(command);
    	powerShellProcess.getOutputStream().close();
    	
    	 BufferedReader stderr = new BufferedReader(new InputStreamReader(
 			    powerShellProcess.getErrorStream()));
 			  while ((line = stderr.readLine()) != null) {
 				System.out.println("Error:");
 		   //System.out.println(line);
 		  }
 		  stderr.close();
    	
    	call();
		
	}
	
	//This method to initiate until rename process complete
	public static void call() throws IOException{
		
		File folder = new File("E:\\Songs");
		  rename(folder);
		
	}

}
