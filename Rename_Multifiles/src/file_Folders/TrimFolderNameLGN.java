package file_Folders;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrimFolderNameLGN {
	
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
		fncondition = null;
		trimCondtion = null;
		line = null;
		fname = null;
		  
		for (File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	line = folder.toString();
	        	fname = folder.getName();
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
	     	  			fname.startsWith("9")){
	        	System.out.println(fname);
	        	nameCheckFolder(fname);
	        	}
	            rename(fileEntry);
	        } else {
	        	line = folder.toString();
	        	fname = folder.getName();
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
	     	  			fname.startsWith("9")){
	        	System.out.println(fname);
	        	nameCheckFolder(fname);
	        	}
	        }
	    }
	}
	
	
public static void nameCheckFolder(String fname) throws IOException{

	//check point for filename prefix and remove that _ to 9
	
	String letter = null;
		String folderName = fname;
		
		if(folderName.contains("("))
    		renameFolder(line, folderName, letter="(" );
		
		else if(folderName.contains(")"))
    		renameFolder(line, folderName, letter=")" );
		
		else if(folderName.startsWith(" "))
    		renameFolder(line, folderName, letter=" " );
    	
    	else if(folderName.startsWith("."))
    		renameFolder(line, folderName, letter="." );
    	
    	else if(folderName.startsWith("_"))
    		renameFolder(line, folderName, letter="_" );
    	
    	else if(folderName.startsWith("#"))
    		renameFolder(line, folderName, letter="#" );
    	
    	else if(folderName.startsWith("0"))
    		renameFolder(line, folderName, letter="0" );
    		
    	else if(folderName.startsWith("1"))
    		renameFolder(line, folderName, letter="1" );
    	
    	else if(folderName.startsWith("2"))
    		renameFolder(line, folderName, letter="2");
    	
    	else if(folderName.startsWith("3"))
    		renameFolder(line, folderName, letter="3" );
    	
    	else if(folderName.startsWith("4"))
    		renameFolder(line, folderName, letter="4" );
    	
    	else if(folderName.startsWith("5"))
    		renameFolder(line, folderName, letter="5" );
    	
    	else if(folderName.startsWith("6"))
    		renameFolder(line, folderName, letter="6" );
    	
    	else if(folderName.startsWith("7"))
    		renameFolder(line, folderName, letter="7" );
    	
    	else if(folderName.startsWith("8"))
    		renameFolder(line, folderName, letter="8" );
    	
    	else if(folderName.startsWith("9"))
    		renameFolder(line, folderName, letter="9" );
    	
    	else{
    		return;
    	}
		
	}
	
	
	public synchronized static void renameFolder(String line,String folderName,String symb) throws IOException{
		
		String newname1 = folderName.replace(symb, "");
		
		/*if(folderName.contains("-"))
			newname1 = folderName.replace("-", " ");*/
		if(folderName.contains("  "))
			newname1 = folderName.replace("  ", "");
		
		if(newname1 == "")
			newname1 = "newfolder";
		
		System.out.println("powershell.exe "+"Rename-Item " +'"'+'"'+line+'"'+'"'+'"'+" –NewName " +'"'+'"'+'"'+newname1+'"'+'"'+'"');
		String[] command = {"powershell.exe ","Rename-Item " +'"'+'"'+line+'"'+'"'+'"'+" –NewName " +'"'+'"'+'"'+newname1+'"'+'"'+'"'};
		
    	Process powerShellProcess = Runtime.getRuntime().exec(command);
    	powerShellProcess.getOutputStream().close();
    	
    	 BufferedReader stderr = new BufferedReader(new InputStreamReader(
 			    powerShellProcess.getErrorStream()));
 			  while ((line = stderr.readLine()) != null) {
 				System.out.println("Error:");
 		   System.out.println(line);
 		  // call();
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
	
	
	public static void call() throws IOException{
		
		File folder = new File("E:\\Songs");
		  rename(folder);
		
	}

}
