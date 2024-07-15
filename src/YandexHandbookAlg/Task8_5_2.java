package YandexHandbookAlg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Task8_5_2 {
    private static HashMap<Integer, Integer> knapMemo = new HashMap<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int W = Integer.parseInt(s.nextLine().split(" ")[0]);
        int[] w = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(knapsack(w, W, new int[]{100,12,4}));
    }

    private static int knapsack(int[] weights, int maxWeight, int[] values){
        int[][] table = new int[weights.length+1][maxWeight+1];
        for (int i = 1; i < weights.length+1; i++) {
            for (int w = 1; w < maxWeight+1; w++) {
                if (weights[i-1] <= w) table[i][w] = Math.max(table[i-1][w], values[i-1] + table[i-1][w - weights[i-1]]);
                else table[i][w] = table[i-1][w];
            }
        }
        return table[weights.length][maxWeight];
    }
}
