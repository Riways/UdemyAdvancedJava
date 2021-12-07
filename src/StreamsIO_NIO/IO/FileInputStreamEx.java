package StreamsIO_NIO.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamEx {
    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("C:\\Users\\aqua-\\Desktop\\Binary\\clouds.jpg");
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\aqua-\\Desktop\\BinaryCopies\\clouds.jpg");
        ){
            int i;
            while((i = fileInputStream.read()) != -1){
                fileOutputStream.write(i);
            }
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
