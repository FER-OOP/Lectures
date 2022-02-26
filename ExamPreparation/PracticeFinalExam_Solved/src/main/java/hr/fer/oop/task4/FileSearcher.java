package hr.fer.oop.task4;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher {
	
	private FileSearchMonitor monitor;
	public FileSearcher(FileSearchMonitor monitor){
		this.monitor = monitor;
	}
	/* 
	 * Search for PDF files from disk root to directory
	 * e.g. if from directory is tmp/Books and to directory is tmp/Books/Java/v8 it search pdfs in
	 * tmp/Books/Java/v8, tmp/Books/Java, tmp/Books (can be ordered in both ways)
	 * for each PDF found, directory change, or end of search it calls appropriate monitor method
	 */
	public List<String> findPDFsInRange(String from, String to){
		List<String> pdfs = new ArrayList<>();
		Path fromPath = Paths.get(from).toAbsolutePath();
		Path toPath = Paths.get(to).toAbsolutePath();
		
		try {
			Files.walkFileTree(fromPath, new MyFileVisitor(toPath.toString(), pdfs));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}	
		monitor.searchFinished();
		return pdfs;
	}
	
	private class MyFileVisitor extends SimpleFileVisitor<Path>{
		
		private Path to;
		private List<String> fileNameList;

		public MyFileVisitor(String toDirectory, List<String> list){
			this.to = Paths.get(toDirectory);
			this.fileNameList = list;
		}	
		
		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			boolean onGoodPath = to.startsWith(dir);
			//ili uspoređivati to.GetName(i) i dir.GetName(i) za i od 0 do dir.getNameCount()
			
			if (onGoodPath) {
				monitor.directoryChangedTo(dir.toString());
				return FileVisitResult.CONTINUE;				
			}
			else{
				return FileVisitResult.SKIP_SUBTREE;
			}
		}
		
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			if (file.toString().toUpperCase().endsWith(".PDF")){
				monitor.fileFound(file.toString());
				fileNameList.add(file.toString());
			}
			return FileVisitResult.CONTINUE;
		}
		
		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			return FileVisitResult.CONTINUE;
		}
	}
}
