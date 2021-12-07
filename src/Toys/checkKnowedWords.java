package Toys;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class checkKnowedWords {
    static final String fileName = "jls1.bin";
    public static void main(String[] args) {
        List<String> unknownWords = new ArrayList<>();
        List<Words> words = new ArrayList<>();
        Words temp;
        try(        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\aqua-\\Desktop\\JAVAS\\Binary\\" + fileName));
        ){
        words =  (ArrayList)objectInputStream.readObject();
            for (Words w:
                 words) {
                System.out.println(w);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
