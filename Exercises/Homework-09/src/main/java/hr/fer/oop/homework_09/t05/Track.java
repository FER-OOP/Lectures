package hr.fer.oop.homework_09.t05;

public class Track {
	private final String artist;
	private final String name;
	private final int duration;
	public Track(String name, String artist, int duration) {
		this.name = name;
		this.artist = artist;
		this.duration = duration;
	}
	public String getArtist() {
		return artist;
	}
	public String getName() {
		return name;
	}
	public int getDuration() {
		return duration;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s", artist, name);
	}
}
