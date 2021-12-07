package StreamsIO_NIO.NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class ChannelBufferEx3 {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("test12.txt", "rw");
            FileChannel channel = file.getChannel()
        ) {
            String strng = "Milk is white and so is glue,\n" +
                    "Ghosts are white, and they say\n" +
                    "BOO!";
            ByteBuffer buffer = ByteBuffer.wrap(strng.getBytes());
            channel.write(buffer);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
