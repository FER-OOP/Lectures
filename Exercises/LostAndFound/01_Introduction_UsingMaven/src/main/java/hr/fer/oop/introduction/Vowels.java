package hr.fer.oop.introduction;

import java.util.Scanner;

public class Vowels {

	public static void main(String[] args) {
		Node head = null;
		Scanner sc = new Scanner(System.in);  
		String line = sc.nextLine();
		System.out.println("Enter one word per line, use KRAJ for end");
		while(line.compareToIgnoreCase("kraj") != 0)  {
			head = CustomLinkedList.add(head, line);
			line = sc.nextLine();
		}
		sc.close();
		
		Node temp = head;
		while(temp != null) {
			int vovels = countVovels(temp.value);
			if (vovels >= temp.value.length() - vovels) {
				System.out.println(temp.value);
			}
			temp = temp.next;
		}	    
	}

	public static int countVovels(String s) {
		int vowel = 0;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			c = Character.toUpperCase(c);
			switch (c) {
			case 'A':case 'E':case 'I':case 'O':case 'U':
				++vowel;
				break;
			}
		}
		return vowel;
	}

}
