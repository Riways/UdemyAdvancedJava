package StreamsIO_NIO.NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PathAndFilesEx3 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test12.txt");
        List<String> list = Files.readAllLines(filePath);
        System.out.println(list);

    }
}
