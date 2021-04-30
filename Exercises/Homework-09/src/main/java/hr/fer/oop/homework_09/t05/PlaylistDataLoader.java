package hr.fer.oop.homework_09.t05;

public class PlaylistDataLoader {
	public static Playlist createPlaylist() {
		Playlist p = new Playlist("Irish folk", 900);
		p.add(new Track("Dirty old town", "The Pogues", 225)); //true
		p.add(new Track("The Galway Girl", "Sharon Shannon", 180)); //true
		p.add(new Track("Drunken Sailor", "The Irish Rovers", 176)); //true
		p.add(new Track("Whiskey in the Jar", "The Dubliners", 179)); //true
		p.add(new Track("The Green Fields of France", "The Fureys", 382)); //false
		p.add(new Track("Whiskey You're the Devil", "Shilelagh Law", 127)); //true
		return p;
	}
}
