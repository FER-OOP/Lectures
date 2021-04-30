package hr.fer.oop.homework_09.t07;

import hr.fer.oop.homework_09.t05.Playlist;
import hr.fer.oop.homework_09.t05.PlaylistDataLoader;
import hr.fer.oop.homework_09.t05.Track;

public class Main {

	public static void main(String[] args) {
		Playlist p = PlaylistDataLoader.createPlaylist();
		printPlaylist(p);
		SortedPlaylist sp = new SortedPlaylist("Sorted " + p.getName());
		for(int i=1, len = p.count(); i <= len; i++) {
			sp.add(p.trackAt(i));
		}
		sp.add(new Track("Seven Drunken Nights", "The Dubliners", 213));
		printPlaylist(sp);		
				
		sp.invert();
		sp.add(new Track("If I Should Fall from Grace with God", "The Pogues", 140));
		printPlaylist(sp);	
	}

	private static void printPlaylist(Playlist p) {
		System.out.format("%s playlist contains %d songs with total duration %ds %n",
				p.getName(), p.count(), p.duration());		
		for(int i=1, len = p.count(); i <= len; i++) {
			System.out.format("%d. %s %ds%n", i, p.trackAt(i), p.trackAt(i).getDuration());
		}
		System.out.println();
	}

}
