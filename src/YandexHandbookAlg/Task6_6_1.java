package YandexHandbookAlg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task6_6_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> list = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        StringBuilder maxResult =new StringBuilder();
        while (!list.isEmpty()){
            int max = 0;
            for(int e : list) if (compare(max, e)) max = e;
            list.remove((Integer) max);
            maxResult.append(max);
        }
        System.out.println(maxResult);
        reader.close();
    }
    private static boolean compare(int a, int b){
        if (b==0) return false;
        if (a==0) return true;
        String s1 = "" + a + b;
        String s2 = "" + b + a;
        return Integer.parseInt(s1) <= Integer.parseInt(s2);
    }
}
