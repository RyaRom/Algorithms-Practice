package YandexHandbookAlg;

import java.util.Scanner;

public class Task6_5_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = 1;
        for (; k <= n; k++) {
            if ((k*(k+1))/2 > n){
                System.out.println(k-1);
                break;
            }
        }
    }
}
