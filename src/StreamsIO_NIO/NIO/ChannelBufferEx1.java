package StreamsIO_NIO.NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx1 {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("test10.txt", "rw");
            FileChannel channel = file.getChannel()
            ) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(25);
            StringBuilder stix = new StringBuilder();
            String strng = " AAAAA white and so is glue,\n" +
                    "Ghosts are white, and they say\n" +
                    "BOO!";

            int byteRead = channel.read(byteBuffer);
            while (byteRead > 0){
                System.out.println("read:  " + byteRead);

                byteBuffer.flip();

                while (byteBuffer.hasRemaining()){
                    stix.append((char) byteBuffer.get());
                }
                System.out.println(stix);
                byteBuffer.clear();
                channel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
