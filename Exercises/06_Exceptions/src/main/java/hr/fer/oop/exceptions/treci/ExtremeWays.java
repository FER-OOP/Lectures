 package hr.fer.oop.exceptions.treci;

public class ExtremeWays {
	
	public static void method1() throws TomahawkException
	{
		method2();
		method4();
	}
	
	public static void method2() throws TomahawkException
	{
		try
		{
			method3();
		}
		catch(ArithmeticException ex)
		{
			System.err.println("Stranded arithmetic error!");
		}
	}
	
	public static void method3() throws TomahawkException
	{
		throw new TomahawkException("Swoosh!");		
	}

	public static void method4() // throws UpException
	{
	    throw new UpException("?!");	
	}

	public static void main(String[] args)
	{
		//method1();
		
		try
		{
			method1();
		}
		catch(TomahawkException | UpException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
