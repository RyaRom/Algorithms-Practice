package YandexHandbookAlg;

import java.util.Arrays;
import java.util.Scanner;

public class Task8_1_1 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        final int[]val = {1,3,4};
        int[] money = new int[n];
        Arrays.fill(money, Integer.MAX_VALUE);
        money[0]=0;
        for (int i = 1; i<n; i++) {
            for (int c : val){
                try {
                    money[i] = Math.min(money[i], 1+money[i - c]);
                } catch (Exception ignored) {
                }
            }
        }
        System.out.println(money[n-1]);
    }
}
