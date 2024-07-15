package YandexHandbookAlg;

import java.util.*;
import java.util.stream.Collectors;

public class Task8_2_1 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int[] memory = new int[n+1];
        Arrays.fill(memory, Integer.MAX_VALUE);
        memory[1] = 0;
        for (int i = 2; i <= n; i++) {
            memory[i] = 1+memory[i-1];
            if(i%3==0) memory[i] = Math.min(memory[i], memory[i/3] + 1);
            else if (i%2==0) memory[i] = Math.min(memory[i], memory[i/2] + 1);
        }
        System.out.println(memory[n]);
        int i = n;
        List<Integer> list = new ArrayList<>();
        while (i>=2){
            list.add(i);
            if (memory[i] == 1+memory[i-1]) i--;
            else if (i%2==0 && memory[i] == 1 + memory[i/2])i = i/2;
            else if (i%3==0 && memory[i] == 1 + memory[i/3]) i = i/3;

        }
        list.add(1);
        Collections.reverse(list);
        System.out.println(list.stream().map(Objects::toString).collect(Collectors.joining(" ")));
    }
}
