package YandexHandbookAlg;

import java.util.Scanner;

public class Task4_2_3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String str1 = s.nextLine();
        String str2 = s.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(str1.charAt(i));
            stringBuilder.append(str2.charAt(i));
        }
        System.out.println(stringBuilder);
    }
}
