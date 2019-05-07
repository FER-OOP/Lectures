package hr.fer.oop.iostreams;

import java.io.IOException;
import java.io.OutputStream;

public class ScrambledOutputStream extends OutputStream {

	private OutputStream stream;
	private byte x;

	public ScrambledOutputStream(OutputStream stream, byte x) {
		this.stream = stream;
		this.x = x;
	}

	@Override
	public void write(int b) throws IOException {
		stream.write(b ^ x);
	}

	@Override
	public void close() throws IOException {
		stream.close();
	}
}
