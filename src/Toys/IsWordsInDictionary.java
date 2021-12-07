package Toys;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IsWordsInDictionary {
    String fileName;
    IsWordsInDictionary(String fileName){
        this.fileName = fileName;
    }
    final static String DICTIONARY = "C:\\Users\\aqua-\\Desktop\\JAVAS\\EnglishBooks\\Dictionary\\large.txt";
    final static String IN = "C:\\Users\\aqua-\\Desktop\\JAVAS\\JavaOut\\";
    final static String OUT = "C:\\Users\\aqua-\\Desktop\\JAVAS\\JavaOut\\OUT\\";
    public void filter() {

        try(BufferedReader reader = new BufferedReader(new FileReader(IN + fileName));
            BufferedReader dictReader = new BufferedReader(new FileReader(DICTIONARY));
            BufferedWriter writer = new BufferedWriter(new FileWriter(OUT + "GOOD" + fileName ));
            BufferedWriter badWriter = new BufferedWriter(new FileWriter(OUT + "BAD" +fileName))
        ){
            List<String> dict = new ArrayList<>();
            List<String> words = new ArrayList<>();
            String temp;
            while ((temp = dictReader.readLine()) != null){
                dict.add(temp);
            }
            while((temp = reader.readLine()) != null){

                int searchResult = Collections.binarySearch(dict, temp);
                if(searchResult < 0){
                    badWriter.write(temp + '\n');
                }else{
                    writer.write(temp + '\n');
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
