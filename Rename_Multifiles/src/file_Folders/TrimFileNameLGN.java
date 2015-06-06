package file_Folders;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrimFileNameLGN {
	
	final static File folder = new File("E:\\Songs");	
	static String fncondition = null;
	static String trimCondtion = null;
	static String line = null;
	static String fname = null;
	
	public static void main (String[] args) throws IOException{
		System.out.println("main starts");
		rename(folder);
		System.out.println("main ends");
	}
	
	public static void rename(File folder) throws IOException{
		
		  
		for (File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            rename(fileEntry);
	        } else {
	        	fname = fileEntry.getName();
	        	if(fname.startsWith(".")||fname.startsWith("_")||fname.startsWith("#")||fname.startsWith("")||fname.startsWith("1")||fname.startsWith("2")||
		 	  			fname.startsWith("3")||fname.startsWith("4")||fname.startsWith("5")||fname.startsWith("6")||fname.startsWith("7")||fname.startsWith("8")||
		 	  			fname.startsWith("9")){
	        	
			        	line = "cd "+'"'+'"'+folder.toString()+'"'+'"'+'"'+";";
			        	
			        	if((fileEntry.getName().contains("("))||(fileEntry.getName().contains(")"))||(fileEntry.getName().contains("  "))||(fileEntry.getName().contains("["))||(fileEntry.getName().contains("]"))){
			        		line = folder.toString()+"\\";
				        	if(fileEntry.getName().contains("(")){
				    			String symb = "(";
				    			renameItem(fileEntry, symb);
				            	call();
				    		}
				        	else if(fileEntry.getName().contains(")")){
				    			String symb =")";
				    			renameItem(fileEntry, symb);
				    			call();
				    		}
				        	else if(fileEntry.getName().contains("  ")){
				    			String symb ="  ";
				    			renameItem(fileEntry, symb);
				    			call();
				        	}
				        	else if(fileEntry.getName().contains("[")){
				    			String symb ="[";
				    			renameItem(fileEntry, symb);
				    			call();
				        	}
				        	else if(fileEntry.getName().contains("]")){
				    			String symb ="]";
				    			renameItem(fileEntry, symb);
				    			call();
				        	}
				        	
			        	}
			        	else
			        	nameCheck(fileEntry);
	        	}
	        }
	    }
	}
	
	public static void nameCheck(File fileEntry) throws IOException{
		
		fname = fileEntry.getName();
		char letter;
    	
    	//check point for filename prefix and remove that _ to 9
		
		if(fname.startsWith(" "))
    		run(line, letter=' ', fname);
    	
    	else if(fname.startsWith("."))
    		run(line, letter='.', fname);
    	
    	else if(fname.startsWith("_"))
    		run(line, letter='_', fname);
    	
    	else if(fname.startsWith("#"))
    		run(line, letter='#', fname);
    	
    	else if(fname.startsWith("0"))
    		run(line, letter='0', fname);
    		
    	else if(fname.startsWith("1"))
    		run(line, letter='1', fname);
    	
    	else if(fname.startsWith("2"))
    		run(line, letter='2', fname);
    	
    	else if(fname.startsWith("3"))
    		run(line, letter='3', fname);
    	
    	else if(fname.startsWith("4"))
    		run(line, letter='4', fname);
    	
    	else if(fname.startsWith("5"))
    		run(line, letter='5', fname);
    	
    	else if(fname.startsWith("6"))
    		run(line, letter='6', fname);
    	
    	else if(fname.startsWith("7"))
    		run(line, letter='7', fname);
    	
    	else if(fname.startsWith("8"))
    		run(line, letter='8', fname);
    	
    	else if(fname.startsWith("9"))
    		run(line, letter='9', fname);
    	
    	else{
    		return;
    	}
		
	}
	
	
	public static void run(String line, char letter, String fname) throws IOException{
		System.out.println(fname);
		
		trimCondtion = "$o = "+'"'+'"'+'"'+fname+'"'+'"'+'"'+"; $n = $o.TrimStart("+'"'+'"'+'"'+letter+'"'+'"'+'"'+");";
		fncondition = " Dir | Rename-Item �NewName { $_.name �replace $o,$n }";
		//System.out.println(trimCondtion);
		//System.out.println(fncondition);
		//System.out.println("powershell.exe "+line + trimCondtion + fncondition);
		String[] command = {"powershell.exe ", line, trimCondtion, fncondition};
    	
    	Process powerShellProcess = Runtime.getRuntime().exec(command);
    	powerShellProcess.getOutputStream().close();
    	
		 BufferedReader stderr = new BufferedReader(new InputStreamReader(
			    powerShellProcess.getErrorStream()));
			  while ((line = stderr.readLine()) != null) {
				System.out.println("Error:");
		   System.out.println(line);
		  }
		  stderr.close();
		  
		  if(fname.startsWith(".")||
	 	  			fname.startsWith("_")||
	 	  			fname.startsWith("#")||
	 	  			fname.startsWith("")||
	 	  			fname.startsWith("1")||
	 	  			fname.startsWith("2")||
	 	  			fname.startsWith("3")||
	 	  			fname.startsWith("4")||
	 	  			fname.startsWith("5")||
	 	  			fname.startsWith("6")||
	 	  			fname.startsWith("7")||
	 	  			fname.startsWith("8")||
	 	  			fname.startsWith("9"))
		  {call();}
		  		  
	}

	public static void renameItem(File fileEntry,String symb) throws IOException{
		String newname1;
		System.out.println(fileEntry.getName());
		fname = fileEntry.getName();
		
		if(fileEntry.getName().contains("&")){
			symb="&";
			newname1 = fname.replace(symb, "!");
			System.out.println("powershell.exe "+"Rename-Item " +'"'+'"'+'"'+line+fname+'"'+'"'+'"'+" �NewName " +'"'+'"'+'"'+newname1+'"'+'"'+'"');
			String[] command = {"powershell.exe "," Rename-Item " +'"'+'"'+'"'+line+fname+'"'+'"'+'"'+" �NewName " +'"'+'"'+'"'+newname1+'"'+'"'+'"'};
	    	Process powerShellProcess = Runtime.getRuntime().exec(command);
	    	powerShellProcess.getOutputStream().close();
	    	call();
		}
		newname1 = fname.replace(symb, "!");
		System.out.println("powershell.exe "+"Rename-Item " +'"'+'"'+'"'+line+fname+'"'+'"'+'"'+" �NewName " +'"'+'"'+'"'+newname1+'"'+'"'+'"');
		String[] command = {"powershell.exe "," Rename-Item " +'"'+'"'+'"'+line+fname+'"'+'"'+'"'+" �NewName " +'"'+'"'+'"'+newname1+'"'+'"'+'"'};
    	Process powerShellProcess = Runtime.getRuntime().exec(command);
    	powerShellProcess.getOutputStream().close();
    	
    	 BufferedReader stderr = new BufferedReader(new InputStreamReader(
 			    powerShellProcess.getErrorStream()));
 			  while ((line = stderr.readLine()) != null) {
 				System.out.println("Error:");
 		   System.out.println(line);
 		  }
 		  stderr.close();
    	
    	call();
		
	}
	
	
	public static void call() throws IOException{
		
		File folder = new File("E:\\Songs");
		  rename(folder);
		
	}
}
