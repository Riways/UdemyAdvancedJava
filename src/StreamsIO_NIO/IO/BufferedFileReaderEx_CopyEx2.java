package StreamsIO_NIO.IO;

import java.io.*;

public class BufferedFileReaderEx_CopyEx2 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader
                (new FileReader("C:\\Users\\aqua-\\Desktop\\freq_1-1000.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\aqua-\\Desktop\\TextResult.txt"))
        ) {
            String strng;
            boolean write = true;
            while ((strng = reader.readLine()) != null) {
                //strng.trim();
                strng += '\n';
                for (int i = 0; i < strng.length(); i++) {

                    if (strng.charAt(i) == '[' ||
                            (strng.charAt(i) >= '0' && strng.charAt(i) <= '9' && i >4)){
                        write = false;
                    }
                    if (strng.charAt(i) == '\n'  || strng.charAt(i) == '-'){
                        write = true;
                    }
                    if(write){
                        writer.write(strng.charAt(i));
                        System.out.print(strng.charAt(i));
                    }

                }
                //System.out.println(strng);
            }
        }
    }

}
