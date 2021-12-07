package StreamsIO_NIO.NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathAndFilesEx2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path filePath = Paths.get("test12.txt");
        Path directoryPath = Paths.get("C:\\Users\\aqua-\\Desktop\\JavasEx");
        Path directoryBPath = Paths.get("C:\\Users\\aqua-\\Desktop\\A");
        //Files.move( directoryPath.resolve("Ghosts.txt"), Path.of("C:\\Users\\aqua-\\IdeaProjects\\VideoCourseTwo\\test12.txt"));
        Files.createDirectory(directoryBPath);
        Thread.sleep(3000);
        Files.copy(filePath, directoryPath.resolve("test6.txt"), StandardCopyOption.REPLACE_EXISTING);
        //Files.copy(directoryBPath, directoryPath.resolve("B"), StandardCopyOption.REPLACE_EXISTING );
        Files.delete(directoryBPath);

    }
}
