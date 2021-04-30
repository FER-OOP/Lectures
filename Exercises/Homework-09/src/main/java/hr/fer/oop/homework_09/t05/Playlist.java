package hr.fer.oop.homework_09.t05;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class Playlist {
	private String name;
	private final OptionalInt limit;
	private final List<Track> tracks = new ArrayList<>();
	private int duration = 0;
		
	public Playlist(String name) {
		this.setName(name);
		this.limit = OptionalInt.empty();
	}
	public Playlist(String name, int durationLimit) {
		this.setName(name);
		this.limit = OptionalInt.of(durationLimit);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int count() {
		return tracks.size();
	}
	
	public int duration() {
		return duration;
	}
	
	public Track trackAt(int i) {
		return tracks.get(i-1);
	}
	
	public void move(int position, int move) {		
		Track t = tracks.remove(position - 1);
		tracks.add(position + move - 1,  t);
	}
	
	public void deleteAt(int position) {		
		Track track = tracks.remove(position - 1);
		duration -= track.getDuration();
	}
	
	public boolean add(Track track) {
		if (limit.isPresent()) {
			if (track.getDuration() + duration > limit.getAsInt())
				return false;
		}
		
		tracks.add(track);
		duration += track.getDuration();
		return true;		
	}
	
	public void invert() {
		for(int i=0, n = tracks.size() ; i < n / 2 ; i++) {
			Track temp = tracks.get(i);
			tracks.set(i, tracks.get(n - 1 - i));
			tracks.set(n - 1 - i, temp);
		}
	}
}
