package StreamsIO_NIO.IO.programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationEx1 {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        employees.add("Viktor");
        employees.add("Oleg");
        employees.add("German");
        try(
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                        new FileOutputStream("C:\\Users\\aqua-\\Desktop\\BinaryCopies\\emloyees1.bin")
                )
                ){
            objectOutputStream.writeObject(employees);
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
