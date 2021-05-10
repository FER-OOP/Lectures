package hr.fer.oop.homework_10.t01;

import java.io.*;
import java.util.Arrays;

public class JuryPoints {	
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {		
		if (args.length != 12) {
			System.out.println("The program needs 12 arguments: year, jury's country name, and 10 countries to assign points to");
			System.exit(1);
		}
				
		PointsSaver.saveJuryPoints(Integer.parseInt(args[0]), args[1], Arrays.copyOfRange(args, 2, 12));
	}

}
