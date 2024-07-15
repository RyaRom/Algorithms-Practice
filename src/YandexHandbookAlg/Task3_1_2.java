package YandexHandbookAlg;

import java.util.Scanner;

public class Task3_1_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        System.out.println(factorial(n)/(factorial(k)*factorial(n-k)));
    }
    private static int factorial(int n) {
        int k = 1;
        for (int i = 1; i <= n; i++) k*=i;
        return k;
    }
}
