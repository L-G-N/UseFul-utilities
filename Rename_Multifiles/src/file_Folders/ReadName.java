package file_Folders;

import java.io.File;

public class ReadName {
		
	final static File folder = new File("E:\\Kamal");	
	
	public static void main (String[] args){
		System.out.println("main starts");
		listFilesForFolder(folder);
	}
	
	public static void listFilesForFolder(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            System.out.println(fileEntry.getName());
	        }
	    }
	}

}
