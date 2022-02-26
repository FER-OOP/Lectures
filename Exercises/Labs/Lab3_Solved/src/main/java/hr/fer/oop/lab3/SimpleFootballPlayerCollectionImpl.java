package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.SimpleFootballPlayerCollection;

/**
 * TODO: Document this class
 */
public class SimpleFootballPlayerCollectionImpl implements SimpleFootballPlayerCollection {

    private FootballPlayer[] players;

    public SimpleFootballPlayerCollectionImpl(int maxSize) {
        players = new FootballPlayer[maxSize];
    }


    @Override
    public int size() {
        int size = 0;
        for (FootballPlayer player : players) {
            if (player != null) {
                size++;
            }
        }
        return size;
    }

    @Override
    public boolean contains(FootballPlayer player) {
        if (player == null)
            return false;
        for (FootballPlayer p : players) {
            if (p != null) {
                if (player.equals(p))
                    return true;
            }
        }

        return false;
    }

    @Override
    public boolean add(FootballPlayer player) {
        if (!contains(player)) {
            for (int i = 0; i < players.length; i++) {
                if (players[i] == null) {
                    players[i] = player;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < players.length; i++) {
            players[i] = null;
        }
    }

    @Override
    public int getMaxSize() {
        return players.length;
    }

    @Override
    public int calculateEmotionSum() {
        int emotionSum = 0;
        for (FootballPlayer p : players) {
            if (p != null)
                emotionSum += p.getEmotion();
        }
        return emotionSum;
    }

    @Override
    public int calculateSkillSum() {
        int skillSum = 0;
        for (FootballPlayer p : players) {
            if (p != null)
                skillSum += p.getPlayingSkill();
        }
        return skillSum;
    }

    @Override
    public FootballPlayer[] getPlayers() {
        return players;
    }
}
