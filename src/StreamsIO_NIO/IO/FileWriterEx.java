package StreamsIO_NIO.IO;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
    static  boolean APPEND = true;
    public static void main(String[] args) {
        String Faust = "Что делать, Фауст?\n" +
                "Таков вам положен предел,\n" +
                "Его ж никто не преступает.\n" +
                "Вся тварь разумная скучает:\n" +
                "Иной от лени, тот от дел;\n" +
                "Кто верит, кто утратил веру;\n" +
                "Тот насладиться не успел,\n" +
                "Тот насладился через меру,\n" +
                "И всяк зевает да живет —\n" +
                "И всех вас гроб, зевая, ждет.\n";
        String end = "Зевай и ты.";
        FileWriter writer = null;
        try {
            if (APPEND){
                writer = new FileWriter("C:\\Users\\aqua-\\Desktop\\Faust.txt", true);
            }
            writer = new FileWriter("C:\\Users\\aqua-\\Desktop\\Faust.txt");
//            for (int i = 0; i < Faust.length(); i++) {
//                writer.write(Faust.charAt(i));
//            }
            writer.write(Faust);
            writer.write(end);
            System.out.println("Done");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
