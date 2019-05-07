package hr.fer.oop.iostreams;

import java.io.IOException;
import java.io.OutputStream;

public class ScrambledOutputStream extends OutputStream{

	private OutputStream stream;
	private byte x, y;
	
	public ScrambledOutputStream(OutputStream stream, byte x, byte y){
		this.stream = stream;
		this.x = x;
		this.y = y;
	}
	@Override
	public void write(int b) throws IOException {		
		stream.write(b ^ x);
		stream.write(b ^ y);
	}
	
	@Override
	public void close() throws IOException {		
		stream.close();
	}

}
