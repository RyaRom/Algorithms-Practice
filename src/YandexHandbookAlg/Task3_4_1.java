package YandexHandbookAlg;

import java.util.Scanner;

public class Task3_4_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println((int)Math.pow(2, n) - 1);
        hanoiRec(n, 1, 3);
    }
    private static void hanoiRec(int n, int from , int to){
        if (n==1) System.out.printf("%s %s\n", from, to);
        else {
            int unused = 6-from-to;
            hanoiRec(n-1, from, unused);
            hanoiRec(1, from, to);
            hanoiRec(n-1, unused, to);
        }
    }
}
