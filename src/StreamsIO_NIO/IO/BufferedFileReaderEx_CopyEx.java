package StreamsIO_NIO.IO;

import java.io.*;

public class BufferedFileReaderEx_CopyEx {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader
                (new FileReader("C:\\Users\\aqua-\\Desktop\\freq_1-1000.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\aqua-\\Desktop\\TesterCopy.txt"))
        ){
            int character;
            boolean write =true;
            while((character = reader.read()) != -1){
                if (character == '[' || (character >= '0' && character <= '9')) {
                    write = false;
                }
                if(character == '-' || character =='\n' || character == ' '){
                    write = true;
                }
                if(write) {
                    writer.write((char) character);
                    System.out.print((char) character);
                }
            }
        }

    }
}
