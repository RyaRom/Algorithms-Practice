package YandexHandbookAlg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task6_4_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] st1 = reader.readLine().split(" ");
        int n = Integer.parseInt(st1[0]);
        int L = Integer.parseInt(st1[1]);
        int[] dots = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count =0;
        Arrays.sort(dots);

        for (int i = 0; i < n;) {
            count += 1;
            int dot = dots[i];
            while (i<n && dot + L >= dots[i]) {
                i++;
            }
        }
        System.out.println(count);

        reader.close();
    }
}
