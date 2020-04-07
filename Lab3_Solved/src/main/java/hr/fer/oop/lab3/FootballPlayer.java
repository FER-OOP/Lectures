package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;

/**
 * TODO: Document this class
 */
public class FootballPlayer extends Person {

    private int playingSkill = Constants.DEFAULT_PLAYING_SKILL;
    private PlayingPosition playingPosition;

    public FootballPlayer(String name, String country, PlayingPosition playingPosition) {
        super(name, country);       
        setPlayingPosition(playingPosition);
    }
    
    public FootballPlayer(String name, String country, int emotion, int playingSkill, PlayingPosition playingPosition) {
        super(name, country, emotion);

        setPlayingSkill(playingSkill);
        setPlayingPosition(playingPosition);
    }
    
    public int getPlayingSkill() {
        return playingSkill;
    }

    public void setPlayingSkill(int playingSkill) {
        if (playingSkill >= Constants.MIN_PLAYING_SKILL && playingSkill <= Constants.MAX_PLAYING_SKILL)
            this.playingSkill = playingSkill;
        else System.err.println("Player's skill is out of range! :(");
    }

    public PlayingPosition getPlayingPosition() {
        return playingPosition;
    }
    
    public void setPlayingPosition(PlayingPosition playingPosition) {
        this.playingPosition = playingPosition;
    }

    
    
}
