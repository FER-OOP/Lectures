package hr.fer.oop.task1;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<String> input = List.of("eat", "dormitory", "TEA", "dirty room", "TEA", "tea",
						   "silent", "ate", "fire", "listen");

		List<Set<String>> result = Solution.groupAnagrams(input);
		for (var group : result) {
			System.out.println(group);
		}
	}
}
