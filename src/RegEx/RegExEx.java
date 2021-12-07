package RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExEx {

    public static void main(String[] args) {
        String string= "ABCD AB CD AAADDDAAD";
        //Pattern pattern1 = Pattern.compile("ABCD");
        Pattern pattern1 = Pattern.compile("A");
        Matcher matcher = pattern1.matcher(string);
//        while (matcher.find()){
//            System.out.println(matcher.group());
//        }
        while (matcher.find()){
            System.out.println(matcher.start() + "   " + matcher.group());
        }
    }
}
