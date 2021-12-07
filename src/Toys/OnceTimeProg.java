package Toys;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class OnceTimeProg {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
//        Path knowed = Paths.get("C:\\Users\\aqua-\\Desktop\\JAVAS\\knowedWords.txt");
//        Path unknowed = Paths.get("C:\\Users\\aqua-\\Desktop\\JAVAS\\unknowedWords.txt");

        FileOutputStream knowed = new FileOutputStream("C:\\Users\\aqua-\\Desktop\\JAVAS\\knowedWords.txt");
        FileOutputStream unknowed = new FileOutputStream("C:\\Users\\aqua-\\Desktop\\JAVAS\\unknowedWords.txt");
        List<String> knowedList = new ArrayList<>();
        List<String> unknowedList = new ArrayList<>();
        Path file = Paths.get("C:\\Users\\aqua-\\Desktop\\JAVAS\\TextResult.txt");
        try {
            list = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int temp;
        Scanner scanner = new Scanner(System.in);
        StringBuilder newWord = new StringBuilder();
        for (String str :
                list) {

            for (int i = 0; i < str.length(); i++) {
                if (i == 0){
                    newWord.delete(0, newWord.length());
                }
                if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {

                    newWord.append(str.charAt(i));
                    if(str.charAt(i + 1) == ' '){
                        break;
                    }
                }
            }
            newWord.append('\n');
            System.out.println(str);

            temp = scanner.nextInt();

            if (temp == (1)) {
                knowedList.add(newWord.toString());
                knowed.write(newWord.toString().getBytes());
            } else {
                unknowedList.add(newWord.toString());
                unknowed.write(newWord.toString().getBytes());
            }

        }
        knowed.close();
        unknowed.close();
    }
}
