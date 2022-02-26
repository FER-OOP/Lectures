package hr.fer.oop.practice.z4_exceptions;

import java.io.Closeable;
import java.io.IOException;

public class Stream implements Closeable {
	private int x;

	public Stream(int x) {
		this.x = x;
		System.out.println("s: constructor " + x);
	}

	@Override
	public void close() throws IOException {
		System.out.println("s: close " + x);
	}
}
