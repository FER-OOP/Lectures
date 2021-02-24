package hr.fer.oop.exceptions.prvi;

public class Prodavac {
	public static void zabiljezi(String zapis)
	{
		try
		{			
			String[] elementi = zapis.split(",");
			float[] podatci = new float[3];
			
			//arbitrarno: ignoriramo visak, gledamo samo prva 3
			for (int i = 0; i < 3; i++)
			{
				podatci[i] = Float.parseFloat(elementi[i]);
			}
			
			float jedinicnaCijena = (podatci[0] - podatci[2]) / podatci[1];
			
			// dijeljenje s float 0 ne izaziva "Div By 0" iznimku
			
			// TODO #3: isprobajte kod ispod
			//if (podatci[1]==0)
			//	throw new ArithmeticException("Dijeljenje s 0!");
			
			// ovo je specificna greska vezana uz domenu problema
			if (jedinicnaCijena < 0)
				throw new IllegalArgumentException("Negativna jedinicna cijena!");
			
			System.out.println("Jedinicna cijena: " + jedinicnaCijena);
			
			//TODO #4 (zadaca): sto ako su predani negativni brojevi?
		}
		/*
		// TODO #1: poredak exceptiona? isprobajte kod ispod
		catch(Exception ex)
		{
			System.err.println("Neka druga greska u zapisu" + ex.getMessage());
		}*/
		//TODO #2: isprobajte zakomentirana prosljedivanja iznimki
		catch(NullPointerException ex)
		{
			System.err.println("Nije poslan zapis");
			
			// omatanje i prosljedjivanje iznimke
			// sto ako se proslijedi bez omatanja?
			//throw new IllegalArgumentException("Nije poslan zapis",ex);
			
		}
		catch(NumberFormatException ex)
		{
			System.err.println("Zapis ne sadrzi brojeve");
			//throw new IllegalArgumentException("Zapis ne sadrzi brojeve", ex);
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.err.println("Zapis nema barem 3 elementa");
			//throw new IllegalArgumentException("Zapis nema barem 3 elementa",ex);
		}
		catch(IllegalArgumentException ex)
		{
			System.err.println(ex.getMessage());
			//throw ex;
		}
		catch(Exception ex)
		{
			System.err.println("Neka druga greska u zapisu: " + ex.getMessage());
			//throw new IllegalArgumentException("Neka druga greska u zapisu",ex);
		}
		
	}
	
	public static void main(String[] args) {
		Prodavac.zabiljezi("12345.45,4,0.12");
		Prodavac.zabiljezi("a,2,2.3");
		Prodavac.zabiljezi("1,2");
		Prodavac.zabiljezi(null);
		Prodavac.zabiljezi("  4, 0,1");
		Prodavac.zabiljezi("  4, 0,4");
		Prodavac.zabiljezi("44, 3, 100");
		Prodavac.zabiljezi("102,12,3,4,5,6,7,8,9,0");
		Prodavac.zabiljezi(",,");
		//Prodavac.zabiljezi("-7,2,-10");
	}

}
