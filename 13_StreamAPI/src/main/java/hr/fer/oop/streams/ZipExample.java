package hr.fer.oop.streams;

import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipExample {
	public static void main(String[] args) {
		String filename = "/tmp/oop/test.zip";
		try(ZipFile zip = new ZipFile(filename)){			
			zip.stream()
			   .filter(entry -> entry.getName().toLowerCase().endsWith(".txt"))
			   .forEach(entry -> {
				   write3LinesWithScanner(zip, entry);
			   });					
		} 
		catch (IOException e) {			
			e.printStackTrace();
		}		
	}

	private static void write3LinesWithScanner(ZipFile zip, ZipEntry entry){
		try (Scanner sc = new Scanner(zip.getInputStream(entry),"UTF-8")) {			
			System.out.format("---%s---%n", entry.getName());
			for(int i=0 ; i<3 && sc.hasNextLine() ; i++){
				String line = sc.nextLine();							
				System.out.println(line);
			}
			System.out.println();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
}