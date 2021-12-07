package StreamsIO_NIO.IO.programmer2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationEx1 {
    public static void main(String[] args) {
        List<String> emplyeesAccepted;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("C:\\Users\\aqua-\\Desktop\\BinaryCopies\\emloyees1.bin")
        )) {
            emplyeesAccepted = (ArrayList)objectInputStream.readObject();
            System.out.println(emplyeesAccepted);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
