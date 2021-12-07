package RegEx;

import java.util.regex.Pattern;

public class ipChecker {
    static void checkIp(String s) {
        String pattern = "((2[0-5][0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.)){3}" +
                "((2[0-5][0-5]|2[0-4]\\d|[0-1]?\\d?\\d))";
        System.out.println(Pattern.matches(pattern, s));
    }

    public static void main(String[] args) {
        String ip1 = "192.162.11.14";
        String ip2 = "392.162.11.14";
        String ip3 = "292.162.11.14";
        checkIp(ip1);
        checkIp(ip2);
        checkIp(ip3);

    }
}
