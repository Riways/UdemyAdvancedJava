package StreamsIO_NIO.IO;

import java.io.*;

public class DataOutputStramEx {
    public static void main(String[] args) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new FileOutputStream("C:\\Users\\aqua-\\Desktop\\BinaryCopies\\test1.bin"));
                DataInputStream dataInputStream = new DataInputStream(
                        new FileInputStream("C:\\Users\\aqua-\\Desktop\\BinaryCopies\\test1.bin"))
        ){
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeByte(5);
            dataOutputStream.writeShort(66);
            dataOutputStream.writeInt(35);
            dataOutputStream.writeUTF("Стринг");
            dataOutputStream.writeFloat(3.14f);

            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readByte());
            System.out.println(dataInputStream.readShort());
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readFloat());
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
