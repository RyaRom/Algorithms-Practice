package contests.tinkoffAcademy2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    private static final BufferedReader fastScanner = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String line = fastScanner.readLine();
        long n = Long.parseLong(line.split(" ")[0]);
        int k = Integer.parseInt(line.split(" ")[1]);
        Long a = Long.valueOf(line.split(" ")[2]);
        Long m = Long.valueOf(line.split(" ")[3]);
        Queue<Integer> sequence = new LinkedList<>();
        long seed = generate(0L, sequence, a, m,10);

        Long answer = 0L;
        long candies = 0L;
        int coins = 0;
        int coinsInMachine = 0;
        while (candies < n){
            coins = coinsInMachine;
//            long candyNow = 0L;
            while (true){
                try {
                    coins += sequence.poll();
                } catch (Exception e) {
                    seed = generate(seed, sequence, a, m,10);
                    coins += sequence.poll();
                }
                answer ++;
                if (coins / 3 >= k){
                    int coinsBought = coins/3;
                    candies += coinsBought;

                    coinsInMachine = coins - k*3;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    private static Long lcg(Long e, Long a, Long m){
        return (a*e+11)%m;
    }
    private static long generate(long seed, Queue<Integer> sequence, Long a, Long m, int len){
        for (int i = 0; i<len;i++){
            seed = lcg(seed, a,m);
            sequence.add((int) ((Math.abs(seed % 3-1)*5 + Math.abs(seed%3)*2)%8));
        }
        return seed;
    }
}

