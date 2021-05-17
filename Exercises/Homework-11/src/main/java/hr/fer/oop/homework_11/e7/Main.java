package hr.fer.oop.homework_11.e7;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Main {

	public static void main(String[] args) {
		
		String s = "the first second was alright but the second second was tough";
		List<String> words = List.of(s.split(" ")); 
		  
		System.out.println(wordCount(words, "was", "a", "the", "second", "tough"));
		
		Map<Character, Integer> frequencyMap = charactersFrequency("otorhinolaryngology"); 
		frequencyMap.forEach((Character k, Integer v)->System.out.format("%c = %d%n", k, v));
		
	}
		
	public static Map<String, Integer> wordCount(List<String> words, String ... lookingFor){
		 Map<String, Integer> wordCountMap = new LinkedHashMap<String, Integer>();
		 for(String word: lookingFor) {
			 wordCountMap.put(word, 0);
		 }
		 
		 for (String word : words) {
			 wordCountMap.computeIfPresent(word, (k,v) -> v+1); 
	     }
		 return wordCountMap;
	}
	
	public static Map<Character, Integer> charactersFrequency(String str){	
		  HashMap<Character,Integer> charFreqMap = new HashMap<>();
	      for(int i= 0 ; i< str.length() ; i++) {
	          Character ch=str.charAt(i);
	          charFreqMap.computeIfPresent(ch, (character,count)-> count+1);
	          charFreqMap.computeIfAbsent(ch, (character)-> 1);
	      }
	      return charFreqMap;
	}
	
}
