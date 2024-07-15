package YandexHandbookAlg;

import java.util.Scanner;

public class Task5_2_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long m = s.nextLong();
        System.out.println(n*m/euclid(n,m));
    }
    private static long euclid(long n, long m) {
        if (n==0 || m==0)return Math.max(n,m);
        return euclid(m, n % m);
    }
}
