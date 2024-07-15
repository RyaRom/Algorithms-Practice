package YandexHandbookAlg;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Task6_1_1 {
    private static Set<String> combinations = new TreeSet<>(Comparator.comparingInt(o -> Integer.parseInt(o.split(" ")[0])));
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] money = new int[3];
        int ten = n/10;
        int five = (n%10)/5;
        int one = n%5;
        moneyness(ten, five, one);
        System.out.println(combinations.size());
        for(String str : combinations){
            System.out.println(str);
        }
    }

    private static void moneyness(int ten, int five, int one){
        String sb = ((ten + five + one) + " " +
                "1 ".repeat(Math.max(0, one)) +
                "5 ".repeat(Math.max(0, five)) +
                "10 ".repeat(Math.max(0, ten))).trim();
        combinations.add(sb);
        if (ten > 0){
           if (!combinations.contains("" + (ten-1 + five+2 + one))) moneyness(ten-1, five+2, one);
        }
        if (five > 0){
            if (!combinations.contains("" + (ten + five-1 + one+5))) moneyness(ten, five-1, one+5);
        }
    }
}
