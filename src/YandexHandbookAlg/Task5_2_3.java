package YandexHandbookAlg;

import java.util.Scanner;

public class Task5_2_3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long fib1 = 0;
        long fib2 = 1;
        long fib3 = 1;
        int n = s.nextInt();
        while (fib3 <= n){
            long oldFib3 = fib3;
            long oldFib2 = fib2;
            fib3 = fib2 + fib3;
            fib2 = oldFib3;
            fib1 = oldFib2;
        }
        System.out.printf("%s %s", fib1, fib2);
    }
}
