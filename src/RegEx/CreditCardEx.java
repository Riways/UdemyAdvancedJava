package RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardEx {
    public static void main(String[] args) {
        String myString = "12345678912345670325987;" +
                "98765432112345670325986;" +
                "12345432112345670325985";
        // 1234 5678 9123 4567 03/25 (987)
        Pattern pattern = Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");// скобками разбиваем на группы для matcher, без пробелов
        Matcher matcher = pattern.matcher(myString);
        System.out.println(matcher);
        //String myNewString = matcher.replaceAll("$5/$6  $1  $2  $3  $4  ($7)");
        System.out.println(matcher);
        //System.out.println(myNewString);
        //System.out.println(myString);
        while (matcher.find()){
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
        }
    }
}
