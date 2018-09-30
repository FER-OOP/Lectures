package hr.fer.oop.introduction;

/**
 * @author OOP course
 * @version 1.0
 */
public class WorkingWithStrings{
   /**
    * This method is called once the program is run.   
    * Arguments are described below
    * @param args Command line arguments.
    */
  public static void main(String[] args) {
	String s1 = new String("Some text.");
  	String s2 = new String("Some text.");
  	System.out.println("s1==s2 " + (s1 == s2));
  	System.out.println("s1.equals(s2) " + s1.equals(s2));

  	String s3 = "Some other text";
  	String s4 = "Some other text";
  	System.out.println("s3==s4 " + (s3 == s4));
  	System.out.println("s3.equals(s4) " + s3.equals(s4));

	displayString1();
	displayString2();
	displayString3();
	displayString4();
  }
  /**
   * String concatenation demo.<br>
   * Concatenation using operator + split across multiple
   * commands is very inefficient. 
   */
  public static void displayString1() {
	String text = null;
	text = "The quick " + "brown ";
	text += "fox jumps over ";
	text += 3;
	text += " lazy dogs.";
	System.out.println(text);
  }

  /**
   * String concatenation demo.<br>
   * Concatenation using operator + in a single line
   * is more efficient. 
   */
  public static void displayString2() {
	String text = null;
	int number = 3;
	text = "The quick brown fox jumps over " + number + " lazy dogs.";
	System.out.println(text);
  }

  /**
   * String concatenation demo.<br>
   * String concatenation using StringBuffer object. 
   * Is it equaly efficient as in the previous method?
   * Initially a buffer of size 16 is created, and 
   * subsequently reallocated three times to fit in the string
   * Note: prior to Java version 5.0 StringBuffer was significantly 
   * slower
   */
  public static void displayString3() {
	String text = null;
	StringBuilder sb = new StringBuilder();
	sb.append("The quick ").append("brown ");
	sb.append("fox jumps over ").append(3);
	sb.append(" lazy dogs.");
	text = sb.toString();
	System.out.println(text);
  }

  /**
   * String concatenation demo.<br>
   * Concatenation using StringBuffer object. 
   * The most efficient way is if the required buffer size is known 
   * in advance. 
   * In the example the buffer of size 50 characters is allocated.
   * Note: prior to Java version 5.0 StringBuffer was significantly 
   * slower
   */
  public static void displayString4() {
	String text = null;
	StringBuilder sb = new StringBuilder(50);
	sb.append("The quick ").append("brown ");
	sb.append("fox jumps over ").append(3);
	sb.append(" lazy dogs.");
	text = sb.toString();
	System.out.println(text);
  }
}
