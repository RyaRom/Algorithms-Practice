package YandexHandbookAlg;

import java.util.Scanner;

public class Task3_1_3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        System.out.println(factorial(n+k-1)/(factorial(k)*factorial(n-1)));
    }
    private static int factorial(int n) {
        int k = 1;
        for (int i = 1; i <= n; i++) k*=i;
        return k;
    }
}