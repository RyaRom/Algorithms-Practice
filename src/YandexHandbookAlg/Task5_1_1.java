package YandexHandbookAlg;

import java.util.Scanner;

public class Task5_1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n==0){
            System.out.println(0);
            return;
        }
        if (n==1){
            System.out.println(1);
            return;
        }
        long[] fib = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        System.out.println(fib[n]);
    }
}
