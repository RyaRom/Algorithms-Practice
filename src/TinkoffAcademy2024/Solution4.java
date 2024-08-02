package TinkoffAcademy2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4 {
    private static final BufferedReader fastScanner = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String line1= fastScanner.readLine();
        int N = Integer.parseInt(line1.split(" ")[0]);
        int M = Integer.parseInt(line1.split(" ")[1]);
        int[][] input = new int[M][2];
        int[][] table = new int[    N][M+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M+1; j++) {
                if (j==0) table[i][j] = 0;
                else  table[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < M; i++) {
            String line= fastScanner.readLine();
            int start = Integer.parseInt(line.split(" ")[0]);
            int finish = Integer.parseInt(line.split(" ")[1]);
            input[i][0] = start;
            input[i][1] = finish;
        }
        for (int j = 1; j < M+1; j++) {
            for (int i = 0; i < N; i++) {
                table[i][j] = table[i][j-1] + dist(i, input[j-1][0], input[j-1][1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < table.length; i++) {
            int j = table[i].length-1;
            min = Math.min(min, table[i][j]);
        }
        System.out.println(min);
    }
    private static int dist(int i, int start, int finish){
        start--;
        finish--;
        if (start <= i && finish >= i) return 0;
        else return Math.min(Math.abs(i-start), Math.abs(i-finish));
    }
}
