package StreamsIO_NIO.NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx2 {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("test11.txt", "rw");
            FileChannel channel = file.getChannel()
        ) {
            String strng = "Milk is white and so is glue,\n" +
                    "Ghosts are white, and they say\n" +
                    "BOO!";
            ByteBuffer buffer = ByteBuffer.allocate(25);
            int counter =0;

            while (counter < strng.length()){
                int localCounter;
                if(strng.length() - counter >= 25){
                    localCounter = 25;
                }else{
                    localCounter = strng.length() - counter;
                }
                for (int i = counter; i < counter + localCounter; i++) {
                    System.out.println(localCounter);
                    char c =  strng.charAt(i);
                    buffer.put((byte)c);
                }
                counter += localCounter;
                buffer.flip();
                while (buffer.hasRemaining()){
                    channel.write(buffer);
                    System.out.println("AAA");
                }
                buffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
