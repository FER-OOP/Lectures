package hr.fer.oop.homework_05.e08;

import java.net.URL;

public class EItem extends LibraryItem {
	private URL url;

	public EItem(int id, String name, URL url) {
		super(id, name);
		this.url = url;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return super.toString() + ", url=" + url;
	}
	
}
