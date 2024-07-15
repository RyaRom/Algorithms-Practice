package YandexHandbookAlg;

import java.util.Arrays;
import java.util.Scanner;

public class Task6_1_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] money = new int[5];
        money[0] = n/50;
        money[1] = (n%50)/20;
        money[2] = ((n%50)%20)/10;
        money[3] = (((n%50)%20)%10)/5;
        money[4] = ( (((n%50)%20)%10)%5);
        String sb = "50 ".repeat(Math.max(0, money[0])) +
                "20 ".repeat(Math.max(0, money[1])) +
                "10 ".repeat(Math.max(0, money[2])) +
                "5 ".repeat(Math.max(0, money[3])) +
                "1 ".repeat(Math.max(0, money[4]));
        System.out.println(Arrays.stream(money).sum());
        System.out.println(sb.trim());
    }
}
