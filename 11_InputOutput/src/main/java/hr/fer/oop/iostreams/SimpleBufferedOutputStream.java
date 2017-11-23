package hr.fer.oop.iostreams;

import java.io.IOException;
import java.io.OutputStream;

public class SimpleBufferedOutputStream extends OutputStream {
	private byte[] buffer = new byte[1024];
	  private int size = 0;
	  private OutputStream wrapped;

	  public SimpleBufferedOutputStream(OutputStream wrapped) {
	    this.wrapped = wrapped;
	  }
	  
	  @Override
	  public void close() throws IOException {
	    flushBuffer();
	    wrapped.close();
	  }

	  @Override
	  public void flush() throws IOException {
	    flushBuffer();
	    wrapped.flush();
	  }

	  private void flushBuffer() throws IOException {
	    if(size>0) {
	      wrapped.write(buffer, 0, size);
	    }
	    size = 0;
	  }
	  
	  @Override
	  public void write(int b) throws IOException {
	    if(size>=buffer.length) {
	      flushBuffer();
	    }
	    buffer[size++] = (byte)b;
	  }
}
