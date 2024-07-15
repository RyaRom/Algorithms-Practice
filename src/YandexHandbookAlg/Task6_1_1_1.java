package YandexHandbookAlg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6_1_1_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] money = new int[3];
        int ten = n/10;
        int five = (n%10)/5;
        int one = n%5;
        String sb = ((ten + five + one) + " " +
                "1 ".repeat(Math.max(0, one)) +
                "5 ".repeat(Math.max(0, five)) +
                "10 ".repeat(Math.max(0, ten))).trim();
        List<String> combinations = new ArrayList<>();
        combinations.add(sb);

        int t, f, o = 0;
        if (ten == 0){
            for (int i = 0; i < five; i++) {
                o = n - i*5;
                String m = ((i + o) + " " +
                        "1 ".repeat(Math.max(0, o)) +
                        "5 ".repeat(i)).trim();
                combinations.add(m);
            }
        }
        for (int i = 0; i < ten; i++) {
            t = n - 10*i;
            f = t/5;
            for (int j = 0; j <= f; j++) {
                o = n - i*10-j*5;
                String m = ((i + j + o) + " " +
                        "1 ".repeat(Math.max(0, o)) +
                        "5 ".repeat(j) +
                        "10 ".repeat(i)).trim();
                combinations.add(m);
            }
        }


        System.out.println(combinations.size());
        for(String str : combinations){
            System.out.println(str);
        }
    }

}
