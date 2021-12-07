package Toys;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class WordCounter {

    static boolean literalCheck(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c == 39 || c == '-';

    }

    static StringBuilder badEndingsRemover(StringBuilder string) {
        int length = string.length();
        if (string.substring(length - 3, length).equals("ies") ||
                string.substring(length - 3, length).equals("ing")) {
            return new StringBuilder(string.substring(0, length - 4));
        } else if (string.substring(length - 2, length).equals("es") ||
                string.substring(length - 2, length).equals("ed")) {
            return new StringBuilder(string.substring(0, length - 3));
        } else if (string.substring(length - 1, length).equals("s")) {
            return new StringBuilder(string.substring(0, length - 2));
        }
        return string;
    }

    public static void eighteenPercentSeek(List<Words> MyDictionary2, int generalWordsCounter,BufferedWriter writerEighteenPercentWords) throws IOException {
        double eighteenPercent =  generalWordsCounter * 0.8;
        double counter = 0;
        for (Words words : MyDictionary2
        ) {

            if (counter < eighteenPercent){
                counter += words.counter;
                writerEighteenPercentWords.write(words.toString());

                continue;
            }
            System.out.println(words.num + " words makes 80 percent of text");
            break;
        }
    }

    static void puttingWordToDict(TreeMap<StringBuilder, Integer> MyDictionary, StringBuilder word) {
        if (MyDictionary.containsKey(word)) {
            Integer count = MyDictionary.get(word);
            count++;
            MyDictionary.replace(word, count);
        } else {
            MyDictionary.put(word, 1);

        }
    }

    public static void main(String[] args) {
        String bookName = "jls1.txt";
        String wordsOnly = "wordsOnly";
        IsWordsInDictionary isWordsInDictionary = new IsWordsInDictionary(wordsOnly + bookName);
        int generalWordsCounter = 0;
        TreeMap<StringBuilder, Integer> MyDictionary = new TreeMap<>();
        List<Words> MyDictionary2 = new ArrayList<>();
        List<Words> eightyPercentWords = new ArrayList<>();
        try (
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\aqua-\\Desktop\\JAVAS\\EnglishBooks\\" + bookName));
                BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\aqua-\\Desktop\\JAVAS\\JavaOut\\" + bookName));
                BufferedWriter writerOnlyWords = new BufferedWriter(new FileWriter("C:\\Users\\aqua-\\Desktop\\JAVAS\\JavaOut\\" + wordsOnly + bookName ));
                BufferedWriter writerEighteenPercentWords = new BufferedWriter(new FileWriter("C:\\Users\\aqua-\\Desktop\\JAVAS\\JavaOut\\" + "EighteenPercentOfWords" + bookName ))
        ) {
            String str;
            StringBuilder word = new StringBuilder();
            boolean nextWord = false;
            while ((str = reader.readLine()) != null) {
                str = str.toLowerCase();
                str += " ";
                for (int i = 0; i < str.length(); i++) {

                    if (literalCheck(str.charAt(i))) {
                        if (nextWord) {
                            word = new StringBuilder(String.valueOf(str.charAt(i)));
                            nextWord = false;
                        } else {
                            word.append(str.charAt(i));
                        }
                    }else{
                        if (word.length() >= 4) {
                            word = badEndingsRemover(word);
                        }
                        puttingWordToDict(MyDictionary, word);
                        nextWord = true;
                    }
                }
            } //added all words to hashMap
            int nums = 1;
            for (StringBuilder strng :
                    MyDictionary.keySet()) {
                Words temp = new Words(strng, MyDictionary.get(strng));
                MyDictionary2.add(temp);
            }//Putwords in list
            Collections.sort(MyDictionary2);

             for (Words words : MyDictionary2) {

                generalWordsCounter += words.counter;
                words.num = nums++;
                writer.write(words.toString());
                writerOnlyWords.write(String.valueOf(words.word) + '\n');
                eightyPercentWords.add(words);
            }
            eighteenPercentSeek(MyDictionary2,  generalWordsCounter, writerEighteenPercentWords);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        isWordsInDictionary.filter();
        String binFileName = bookName.substring(0, bookName.length() - 4 ) + ".bin";
        try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("C:\\Users\\aqua-\\Desktop\\JAVAS\\Binary\\" + binFileName))){
            objOut.writeObject(eightyPercentWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

