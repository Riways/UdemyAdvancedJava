package StreamsIO_NIO.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesEx {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("C:\\\\Users\\\\aqua-\\\\Desktop\\\\Faust.txt");) {
            int character;
            while ((character = reader.read()) != -1){
                System.out.print((char) character);
            }
            System.out.println();
            System.out.println("Done!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
