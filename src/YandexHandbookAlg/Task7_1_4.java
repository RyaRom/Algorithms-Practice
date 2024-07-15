package YandexHandbookAlg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task7_1_4 {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s  =reader.readLine();
            int n = Integer.parseInt(s.split(" ")[0]);
            int k = Integer.parseInt(s.split(" ")[1]);
            int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr);
            int count, size= 0;
            int minSize = 0;
            int maxSize = arr[n-1];
            int bestSize = maxSize;
            while (minSize<=maxSize) {
                size = (minSize + maxSize)>>1;
                count = 0;
                boolean flag = true;
                for (int i = 0; i < n;) {
                    int min = arr[i];
                    count++;
                    if (count > k) {
                        flag = false;
                        break;
                    }
                    while (i<n && arr[i] <= min + size)i++;
                }
                if (flag){
                    maxSize = size-1;
                    bestSize = Math.min(size, bestSize);
                }
                else minSize = size+1;
            }
            System.out.println(bestSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
