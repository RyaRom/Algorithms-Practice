package YandexHandbookAlg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task6_3_1 {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            int n = Integer.parseInt(reader.readLine());
            List<Long> prices = Arrays.stream(reader.readLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
            List<Long> clicks = Arrays.stream(reader.readLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
            Collections.sort(prices);
            Collections.sort(clicks);
            long value = 0;
            for (int i = 0; i < n; i++) {
                if (prices.isEmpty()|| clicks.isEmpty()) break;
                value += prices.get(i) * clicks.get(i);
            }
            System.out.println(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
