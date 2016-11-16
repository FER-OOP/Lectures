package hr.fer.oop.practice.io;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class MyFileVisitor extends SimpleFileVisitor<Path> {

    public Map<String, Long> map;
    private final String root;
    
    //constant value which represents the size of a directory
    private static final Long NOSIZE = -1L;

    public MyFileVisitor(String root) {
        this.root = root;
        map = new HashMap<>();
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {        
        if (!dir.toString().equals(root)) {
            map.put(dir.toString().replace(root, ""), NOSIZE);
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        map.put(file.toString().replace(root, ""), attrs.size());
        
        return FileVisitResult.CONTINUE;
    }
}