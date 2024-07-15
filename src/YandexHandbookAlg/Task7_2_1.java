package YandexHandbookAlg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class Task7_2_1 {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();
            long[] a = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            System.out.println(dominant(a));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static int dominant(long[] arr){
        TreeMap<Long, Long> map = new TreeMap<>();
        for (long n : arr){
            long pr = map.get(n)==null?0:map.get(n);
            map.put(n, pr + 1);
        }
        if (map.size() >= 3){
            long a1 = map.pollLastEntry().getValue();
            long a2 = map.pollLastEntry().getValue();
            long a3 = map.pollLastEntry().getValue();
            if (a1 > arr.length/4 && a3 > arr.length/4 && a2 > arr.length/4) return 1;
        }
        return 0;
    }
}
