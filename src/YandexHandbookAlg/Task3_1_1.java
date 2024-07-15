package YandexHandbookAlg;

import java.util.Scanner;

public class Task3_1_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = 1;
        for (int i = 1; i <= a; i++) b*=i;
        System.out.println(b);
    }
}
