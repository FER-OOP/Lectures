package hr.fer.oop.nio.dirtree;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) { 
		try (Scanner sc = new Scanner(System.in)){
			System.out.println("Enter directory:");
			String dirName = sc.nextLine();
			directoryTree(dirName, 0);
		}	
	}	
	
	public static void directoryTree(String root, int level){
		Path directory = Paths.get(root);
		int nameCounts = directory.getNameCount();
		print(level, directory.getName(nameCounts-1).toString(), false);		
				
		DirectoryStream.Filter<Path> filter = new MyPathStreamFilter();
		
		try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(directory, filter)){
			for(Path path : dirStream){
				BasicFileAttributes attribs = Files.readAttributes(path, BasicFileAttributes.class);
				if (attribs.isDirectory()){ //or Files.isDirectory...
					directoryTree(path.toAbsolutePath().toString(), level + 1);
				}
				else{
					print(level+1, String.format("%s (%s bytes) (%s) ",
							path.getName(path.getNameCount()-1).toString(), 
							attribs.size(), attribs.lastModifiedTime().toString()
							), true);
				}
			}
		}
	    catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void print(int level, String name, boolean isFile) {
		if (level != 0)
			System.out.print("|");		
		for(int i=0; i<level-1; i++)
			System.out.print(isFile? " " :  "-");
		System.out.println(name);
	}
}
