package StreamsIO_NIO.IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("Test10.txt" , "rw")){
            String s1 = file.readLine();
            int a = file.read();
            System.out.println(s1);
            System.out.println((char) a);
            file.seek(56);
            a=file.read();

            System.out.println((char) a);
            System.out.println(file.getFilePointer());
            file.seek(0);
            file.writeUTF("AAAAA");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
