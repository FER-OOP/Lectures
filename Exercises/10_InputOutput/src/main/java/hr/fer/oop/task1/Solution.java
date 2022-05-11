package hr.fer.oop.task1;

import java.util.*;

public class Solution {
	
	public static List<Set<String>> groupAnagrams(Iterable<String> words) {
		Map<String, Set<String>> groups = new HashMap<>();
		for(String word : words) {
			char[] letters = word.toLowerCase().toCharArray();
			Arrays.sort(letters);
			String sorted = new String(letters).trim();
			Set<String> group = groups.get(sorted);
			if (group == null) {
				group = new TreeSet<>();
				groups.put(sorted, group);
			}
			group.add(word);
		}
		
		List<Set<String>> list = new ArrayList<>(groups.size());
		for(Set<String> group : groups.values()) {
			list.add(group);
		}
		return list;
	}
}
