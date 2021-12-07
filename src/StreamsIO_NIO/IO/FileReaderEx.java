package StreamsIO_NIO.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("C:\\\\Users\\\\aqua-\\\\Desktop\\\\Faust.txt");
            int character;
            while ((character = reader.read()) != -1){
                System.out.print((char) character);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("Done!");

    }
}
