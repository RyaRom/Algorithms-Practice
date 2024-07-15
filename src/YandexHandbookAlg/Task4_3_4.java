package YandexHandbookAlg;

import java.util.Arrays;
import java.util.Scanner;

public class Task4_3_4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long a [] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextLong();
        }
        Arrays.sort(a);
        long q = a[a.length-4]* a[a.length-3]* a[a.length-2]* a[a.length-1];
        long w = a[0]* a[1]* a[a.length-2]* a[a.length-1];
        long e = a[0]* a[1]* a[2]* a[3];
        System.out.println(Math.max(q,Math.max(w,e)));
    }
}
