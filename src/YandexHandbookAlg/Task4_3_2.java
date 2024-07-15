package YandexHandbookAlg;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task4_3_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        if (n<=2) {
            System.out.println("No");
            return;
        }
        a[0] = n;
        a[1] = 1;
        for (int i = 2; i < n; i++) {
            a[i] = i;
        }
        long op = fast2Max(a);
        if (op <= n*1.5){
            System.out.println("No");
        }else {
        System.out.println("Yes");
        System.out.println(Arrays.stream(a).boxed().map(Object::toString).collect(Collectors.joining(" ")));
        }
    }
    private static long fast2Max(int[] a) {
        long max1 = a[0];
        long max2 = a[1];
        long op = 1;
        if (max2 > max1){
            long sw = max1;
            a[0] = (int) max2;
            a[1] = (int) sw;
        }
        for (int i = 2;i<a.length ;i++) {
            int n = a[i];
            op ++;
            if (n<=max1) op++;
            if (n > max1) {
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max2 = n;
            }
        }
        return op;
    }
}
