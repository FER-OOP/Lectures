package hr.fer.oop.exceptions.drugi;

import java.util.Arrays;

public class Bankar {

	public static void pohlepnoGrabljenje()
	{
		char [] gimme = new char [Integer.MAX_VALUE];
		Arrays.fill(gimme, '$');
		System.out.println("Uspjeh!");
	}
	
	public static void main(String[] args) {
		try
		{
			pohlepnoGrabljenje();	
		}
		catch (Exception ex)
		{
			System.err.println("Ha! Uhvacen na djelu!" + ex.getMessage());
		}
		/*
		//TODO #1: sto se sve moze uhvatiti?
		catch(Bankar ex)
		{
		}
		*/ 
	}

}
