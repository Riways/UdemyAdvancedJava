package Toys;

import java.io.*;
import java.util.*;

public class newWordCounter {

//    static boolean literalCheck (char c){
//        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c == 39 || c == '-';
//
//    }
    public static void main(String[] args) {
        String bookName = "jls1.txt";
        IsWordsInDictionary isWordsInDictionary = new IsWordsInDictionary(bookName);
        int generalWordsCounter = 0;
        int percentCounter = 0;
        TreeMap<StringBuilder, Integer> MyDictionary = new TreeMap<>();
        List <Words2> MyDictionary2 = new ArrayList<>();
        try (
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\aqua-\\Desktop\\JAVAS\\EnglishBooks\\" + bookName));
                BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\aqua-\\Desktop\\JAVAS\\JavaOut\\" + bookName))
        ) {
            String str;
            StringBuilder word = new StringBuilder();
            boolean nextWord = false;
            while ((str = reader.readLine()) != null) {
                str = str.toLowerCase();
                str += " ";

                for (int i = 0; i < str.length(); i++) {
                    if (Character.isAlphabetic(str.charAt(i))) {
                        if (nextWord) {
                            word = new StringBuilder(String.valueOf(str.charAt(i)));
                            nextWord = false;
                        }else {
                            word.append(str.charAt(i));
                        }
                        if(!Character.isAlphabetic(str.charAt(i + 1))){
                            if (MyDictionary.containsKey(word)){
                                Integer count = MyDictionary.get(word);
                                count++;
                                MyDictionary.replace(word, count);
                                nextWord = true;
                            } else {
                                MyDictionary.put(word, 1);
                                nextWord = true;
                            }
                        }
                    }

                } //added all words to hashMap

            }
            int nums = 1;
            for (StringBuilder strng:
                    MyDictionary.keySet()) {
                Words2 temp = new Words2(strng, MyDictionary.get(strng));
                MyDictionary2.add(temp);
            }
            Collections.sort(MyDictionary2);

            for (Words2 words : MyDictionary2) {
                if(words.counter > 60) {
                    percentCounter += words.counter;
                }
                generalWordsCounter += words.counter;
                words.num = nums++;
                writer.write(words.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        double answer =  (double)percentCounter/(double) generalWordsCounter;
        isWordsInDictionary.filter();
        System.out.println(answer);
    }
}

class Words2 implements Comparable<Words2>{
    Integer num;
    StringBuilder word;
    Integer counter;
    Words2(StringBuilder word, Integer counter){
        this.word= word;
        this.counter = counter;
    }


    @Override
    public int compareTo(Words2 o) {
        return o.counter - this.counter;
    }

    @Override
    public String toString() {

        return num + " Word = " + word +
                ", counter = " + counter +
                '\n';
    }
}
