package hr.fer.oop.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class DirTree {

	public static void main(String[] args) { 
		try (Scanner sc = new Scanner(System.in)){
			System.out.println("Enter directory:");
			String dirName = sc.nextLine();
			directoryTree(dirName, 0);
		}			
	}	
	
	private static void print(int level, String stringToPrint, boolean isFile) {
		if (level != 0)
			System.out.print("|");		
		for(int i=0; i<level-1; i++)
			System.out.print(isFile? " " :  "-");
		System.out.println(stringToPrint);
	}
	
	public static void directoryTree(String root, int level){
		File directory = new File(root);
		print(level, directory.getName(), false);				
		
		FilenameFilter filter = new MyFilenameFilter();		
		File[] files = directory.listFiles(filter);
		for(File file : files){
			if (file.isDirectory()){
				directoryTree(file.getAbsolutePath(), level + 1);
			}
			else{
				print(level+1, String.format("%s (%s bytes) ", file.getName(), 
						file.length()), true);
			}			
		}
	}
}
