package hr.fer.oop.anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
  public static List<List<String>> groupAnagrams(String[] words) {
    Map<String, List<String>> map = new HashMap<>(); // k: chars in alphabet order; v: list of words

    for (String word: words) {
      String wordWithAlphabetChars = sortWord(word);
      if (!map.containsKey(wordWithAlphabetChars)) {
        map.put(wordWithAlphabetChars, new ArrayList<>());
      }
      map.get(wordWithAlphabetChars).add(word);
    }

    List<List<String>> resutList = new ArrayList<>();
    for(List<String> l: map.values())
      resutList.add(l);

    return resutList;
  }

  private static String sortWord(String word) {
    char[] characters = word.toCharArray();
    Arrays.sort(characters);
    return new String(characters);
  }

  public static void main(String[] args) {
     String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

     List<List<String>> result = Solution.groupAnagrams(input);
     for(List<String> group: result) {
       System.out.println(group);
     }
  }
}
