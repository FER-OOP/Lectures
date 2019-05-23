package hr.fer.oop.zad1;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyFileVisitor extends SimpleFileVisitor<Path>{
	private static final int MAX_ITEM = 10;
	private List<String> extensions;
	private long sum = 0;
	private Set<Item> tenBiggest = new TreeSet<Item>();
	
	public MyFileVisitor(List<String> extensions) {
		this.extensions = extensions;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		for (String extension : this.extensions) {
			if (file.toString().endsWith(extension)) {
				long itemSize = file.toFile().length();
				sum += itemSize;
				if (this.tenBiggest.size() >= MAX_ITEM) {
					Item smallest = ((TreeSet<Item>) this.tenBiggest).last();
					if (smallest.getSize() < itemSize) {
						this.tenBiggest.remove(smallest);					
						this.tenBiggest.add(new Item(file, itemSize));
					}
				} else {
					this.tenBiggest.add(new Item(file, itemSize));
				}
				break;
			}
		}
		return FileVisitResult.CONTINUE;
	}
	
	public Set<Item> getTenBiggest() {
		return this.tenBiggest;
	}
	
	public long getTotalSum() {
		return this.sum;
	}
}
