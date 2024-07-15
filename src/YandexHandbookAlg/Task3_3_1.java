package YandexHandbookAlg;

import java.util.Scanner;

public class Task3_3_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        if (n%2 == 0 && m%2==0) System.out.println("Loose");
        else System.out.println("Win");
    }
}
