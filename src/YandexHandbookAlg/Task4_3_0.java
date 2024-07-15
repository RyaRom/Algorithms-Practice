package YandexHandbookAlg;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Task4_3_0 {

    private static void stressTesting() {
        for (int i = 0; i < 100000; i++) {
            int size = new Random().nextInt(2, 1000);
            int a[] = randomisedArray(size, 100000);
            long m1 = fast2Max(a);
            long m2 = slow2Max(a);
            System.out.printf("Max fast = %s, Max slow = %s\n\n\n", m1, m2);
            if (m1!=m2){
                throw new RuntimeException("Inaccurate alg");
            }
        }
    }

    private static int[] randomisedArray(int size, int maxElementSize) {
        Random random = new Random();
        int a[] = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = random.nextInt(0, maxElementSize);
        }
        return a;
    }

    private static long fast2Max(int[] a) {
        long max1 = Integer.MIN_VALUE;
        long max2 = Integer.MIN_VALUE;
        for (int n : a) {
            if (n > max1) {
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max2 = n;
            }
        }
        long max = max1 * max2;
        String s =String.format("%s = Max production;; Array is %s\nmax1 = %s; max2 = %s;\n",max, Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")) , max1, max2);
        System.out.println(s);
        return max;
        }

        private static long slow2Max(int []a){
        int n = a.length;
            long max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i!=j && (long) a[i] * a[j] > max){
                        max = (long) a[i] * a[j];
                    }
                }
            }
            return max;
        }

        private static void Fast3Max ( int[] a){
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int max3 = Integer.MIN_VALUE;
            int count = 0;
            for (int n : a) {
                count++;
                if (n > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = n;
                    count++;
                } else if (n > max2) {
                    max3 = max2;
                    max2 = n;
                    count++;
                } else if (n > max3) {
                    max3 = n;
                    count++;
                }
            }
            System.out.printf("Array is %s\nmax1 = %s; max2 = %s; max3 = %s; %s operations assembled\n", Arrays.toString(a), max1, max2, max3, count);
        }


    public static void main(String[] args)
    {
        stressTesting();
    }
}
