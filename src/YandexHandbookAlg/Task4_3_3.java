package YandexHandbookAlg;

import java.util.Arrays;
import java.util.Scanner;

public class Task4_3_3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long a[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextLong();
        }
        Arrays.sort(a);
        long m1 = a[a.length-1] * a[a.length-2] * a[a.length-3];
        long m2 = a[a.length-1] * a[0] * a[1];
        System.out.println(Math.max(m1,m2 ));
    }
}
