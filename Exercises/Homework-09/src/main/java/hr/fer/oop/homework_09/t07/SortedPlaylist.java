package hr.fer.oop.homework_09.t07;

import hr.fer.oop.homework_09.t05.Playlist;
import hr.fer.oop.homework_09.t05.Track;

public class SortedPlaylist extends Playlist {
	
	private boolean ascending = true;
	public SortedPlaylist(String name) {
		super(name);
	}
	public SortedPlaylist(String name, int durationLimit) {
		super(name, durationLimit);
	}
	
	@Override
	public void move(int position, int move) {
		throw new RuntimeException("Sorted playlist cannot be rearanged.");
	}
		
	@Override
	public boolean add(Track track) {
		if (super.add(track)) {
			int currentPosition = count();
			if (ascending) {
				for(int i=1 ; i < currentPosition; i++) {
					if (track.getDuration() < trackAt(i).getDuration()) {
						super.move(currentPosition, i - currentPosition);
						break;
					}
				}
			}
			else {
				for(int i=1 ; i < currentPosition; i++) {
					if (track.getDuration() > trackAt(i).getDuration()) {
						super.move(currentPosition, i - currentPosition);
						break;
					}
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public void invert() {
		ascending = !ascending;
		super.invert();
	}
}
