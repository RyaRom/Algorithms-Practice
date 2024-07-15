package YandexHandbookAlg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task6_4_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] st1 = reader.readLine().split(" ");
        int n = Integer.parseInt(st1[0]);
        int k = Integer.parseInt(st1[1]);
        int[] dots = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(dots);

        int L = 0;
        while (true) {
            boolean flag = true;
            for (int i = 0; i < n;i++) {
                if (dots[i] > (L+1) * k){
                    flag = false;
                    break;
                }
            }
            if (flag)break;
            L++;
        }
        System.out.println(L);

        reader.close();
    }
}
