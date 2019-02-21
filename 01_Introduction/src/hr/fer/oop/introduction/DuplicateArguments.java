package hr.fer.oop.introduction;
public class DuplicateArguments {
   public static void main(String[] args) { 
      boolean found = false;
      for(int i = 0; i < args.length - 1; i++) { 
    	  for(int j = i + 1; j < args.length; j++) { 
    		  if (args[i].equals(args[j])) {
    			  found = true;
    			  break;
    		  }
    	  }
      }
      if (found) {
    	  System.out.println("Duplicate arguments found!");
      }
      else {
    	  System.out.println("No duplicates");
      }
    }
}
