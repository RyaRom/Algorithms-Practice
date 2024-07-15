package YandexHandbookAlg;

import java.util.Scanner;

public class Task3_3_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        boolean flag = false;
        for (int k = -Math.max(n,m); k < Math.max(n,m); k++) {
            if (n == m + 3 * k) {
                flag = true;
                break;
            }
        }
        if (flag) System.out.println("Loose");
        else System.out.println("Win");
    }
}
