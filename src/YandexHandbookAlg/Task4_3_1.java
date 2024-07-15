package YandexHandbookAlg;

import java.util.Scanner;

public class Task4_3_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a [] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println(fast2Max(a));

    }
    private static long fast2Max(int[] a) {
        long max1 = Integer.MIN_VALUE;
        long max2 = Integer.MIN_VALUE;
        for (int n : a) {
            if (n > max1) {
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max2 = n;
            }
        }
        return max1 * max2;
    }

}
