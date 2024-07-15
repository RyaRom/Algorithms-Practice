package YandexHandbookAlg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task7_1_3 {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();
            int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            reader.readLine();
            int[] keys = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            StringBuilder ans = new StringBuilder();
            for (int key : keys){
                ans.append(binarySearch(key, a, 0 , a.length-1)).append(" ");
            }
            System.out.println(ans.toString().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int binarySearch(int key, int[] arr, int minIndex, int maxIndex){
        int midIndex;
        int ans = 0;
        while (minIndex <= maxIndex){
            midIndex = (maxIndex + minIndex)>>1;
            if (arr[midIndex]==key){
                ans++;
                int i = midIndex +1;
                while (i<=maxIndex && arr[i] == key){
                    ans++;
                    i++;
                }
                i = midIndex-1;
                while (i>=minIndex && arr[i] == key){
                    ans++;
                    i--;
                }
                return ans;
            }
            if (arr[midIndex] > key) maxIndex = midIndex-1;
            if (arr[midIndex] < key) minIndex = midIndex+1;
        }
        return ans;
    }
}
