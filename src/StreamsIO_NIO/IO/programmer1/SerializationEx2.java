package StreamsIO_NIO.IO.programmer1;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationEx2 {
    public static void main(String[] args) {
        Car car = new Car("Aston Martin", "Grey");
        Employees employees = new Employees("Mariya","Ivanova","IT",
                //28,
                500, car);
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("C:\\Users\\aqua-\\Desktop\\BinaryCopies\\emloyees2.bin")
        )) {
            objectOutputStream.writeObject(employees);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
