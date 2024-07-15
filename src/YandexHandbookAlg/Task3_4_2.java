package YandexHandbookAlg;

import java.util.Arrays;
import java.util.Scanner;

public class Task3_4_2 {
    private static int[] optimalSplit;
    private static int[] optimalVarK;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        optimalSplit = new int[n+2];
        optimalVarK = new int[n+2];
        Arrays.fill(optimalSplit, Integer.MAX_VALUE);
        optimalSplit[0] = 0;
        optimalSplit[1] = 1;
        calculateOptimal(n+1);
        System.out.println(optimalSplit[n]);
        hanoiRecForFourPegs(n, 1, 4, 2 ,3);
    }

    private static int calculateOptimal(int n){
        if (optimalSplit[n] != Integer.MAX_VALUE) return optimalSplit[n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < i; k++) {
                if (optimalSplit[i] > 2*optimalSplit[k] + Math.pow(2, i-k)-1){
                    optimalSplit[i] = (int) (2*optimalSplit[k] + Math.pow(2, i-k)-1);
                    optimalVarK[i] = k;
                }
            }
        }
        return 0;
    }

    private static void hanoiRecForFourPegs(int n, int from, int to,  int unused1,  int unused2){
        if (n==0) return;
        if (n==1) System.out.printf("%s %s\n", from, to);
        else {
            int k = optimalVarK[n];
            hanoiRecForFourPegs(k, from, unused1, to, unused2);
            hanoiRecForThreePegs(n-k, from, to, unused2);
            hanoiRecForFourPegs(k, unused1, to, unused2 ,from);
        }
    }
    private static void hanoiRecForThreePegs(int n, int from , int to, int unused){
        if (n==1) System.out.printf("%s %s\n", from, to);
        else {
            hanoiRecForThreePegs(n-1, from, unused, to);
            hanoiRecForThreePegs(1, from, to, unused);
            hanoiRecForThreePegs(n-1, unused, to, from);
        }
    }
}
