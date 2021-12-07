package Scanner;

import java.util.Scanner;

public class ScannerEx1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Vvedite chislo");
//        int i = scanner.nextInt();
//        System.out.println("Wwedennoe chislo: " + i);
//        System.out.println("Napishite 2 chisla");
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        System.out.println("Chastnoe = " + a/b);
//        System.out.println("Ostatok = " + a%b);
//        System.out.println("Napishite paru slov ");
//        String s1 = scanner.nextLine();
//        String s2 = scanner.next();
//        System.out.println("Vi napisali v pervoi stroke " + s1);
//        System.out.println("Pervoe slovo vtoroi stroki: " + s2);
        System.out.println("Vvedite drobnoe chislo");// в консоли через запятую
        double d = scanner.nextDouble();
        System.out.println("Vi vveli: " + d);
        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

}
