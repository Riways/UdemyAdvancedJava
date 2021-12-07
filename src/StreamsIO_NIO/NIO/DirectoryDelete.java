package StreamsIO_NIO.NIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoryDelete {
    public static void main(String[] args) throws IOException {
        Path destination = Paths.get("C:\\Users\\aqua-\\Desktop\\JavasCopy");
        Files.walkFileTree(destination, new MyFileVisitor3());
    }
}


class MyFileVisitor3 extends SimpleFileVisitor<Path>{
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.delete(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        Files.delete(dir);
        return FileVisitResult.CONTINUE;
    }
}