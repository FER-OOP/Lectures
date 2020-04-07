package hr.fer.oop.lab3.demo;

import hr.fer.oop.lab3.FootballPlayer;
import hr.fer.oop.lab3.Person;
import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;

public class FootballPlayerTest {

	public static void main(String[] args) {

		FootballPlayer goalkeeper = new FootballPlayer("Player", "Country", PlayingPosition.GK);
		goalkeeper.setPlayingSkill(120);
		if (goalkeeper.getPlayingSkill() != Constants.DEFAULT_PLAYING_SKILL) {
			System.err.println("TEST FAILED: Invalid playing skill!");
		}
		int skill = 40;
		goalkeeper.setPlayingSkill(skill);
		goalkeeper.setPlayingSkill(-20);
		if (goalkeeper.getPlayingSkill() != skill) {
			System.err.println("TEST FAILED: Invalid playing skill!");
		}
		
		int emotion = 70;
		
		goalkeeper = new FootballPlayer("Player2", "Country2", emotion, skill,  PlayingPosition.GK);		
		Person person = goalkeeper;		
		person.setEmotion(emotion);
		goalkeeper.setEmotion(150);
		if (goalkeeper.getEmotion() != emotion) {
			System.err.println("TEST FAILED: Invalid emotion value!");
		}
		
		System.out.println("Ensure there are no 'TEST FAILED' messages before this message, and then write own tests.");

	}
}
