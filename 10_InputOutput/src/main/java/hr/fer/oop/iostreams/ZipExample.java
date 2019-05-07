package hr.fer.oop.iostreams;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipExample {
	public static void main(String[] args) {
		String filename = "/tmp/oop/test.zip";
		try(ZipFile zip = new ZipFile(filename)){
			Enumeration<? extends ZipEntry> entries = zip.entries();
			while(entries.hasMoreElements()){
				ZipEntry entry = entries.nextElement();
				if (entry.getName().toLowerCase().endsWith(".txt")){
					//write3Lines(zip, entry);
					write3LinesWithScanner(zip, entry);
				}
			}				
		} 
		catch (IOException e) {			
			e.printStackTrace();
		}		
	}	
	
	private static void write3Lines(ZipFile zip, ZipEntry entry){
		try (InputStream stream = zip.getInputStream(entry)){			
			BufferedReader br = new BufferedReader(
									new InputStreamReader(
										new BufferedInputStream(stream), "UTF-8"
									)
								);
			System.out.format("---%s---%n", entry.getName());
			for(int i=0 ; i<3 ; i++){
				String line = br.readLine();
				if (line == null) break;					
				System.out.println(line);
			}
			System.out.println();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
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