package StreamsIO_NIO.IO.programmer2;

import StreamsIO_NIO.IO.programmer1.Employees;

import java.io.*;

public class SerializationEx2 {
    public static void main(String[] args) {
        Employees employees;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("C:\\Users\\aqua-\\Desktop\\BinaryCopies\\emloyees2.bin")
        )) {
            employees = (Employees) objectInputStream.readObject();
            System.out.println(employees);
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
