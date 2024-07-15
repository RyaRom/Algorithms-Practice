package YandexHandbookAlg;

import java.util.Scanner;

public class Task5_2_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        System.out.println(euclid(n,m));
    }
    private static int euclid(int n, int m) {
        if (n==0 || m==0)return Math.max(n,m);
        return euclid(m, n % m);
    }
}
