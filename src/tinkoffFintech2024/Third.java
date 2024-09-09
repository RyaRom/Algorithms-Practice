package tinkoffFintech2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Third {
    private static final BufferedReader fastScan = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(fastScan.readLine());
        int[][] matrix = new int[n][n];
        int[] cols = new int[n];
        int[] rows = new int[n];

        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(fastScan.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
            for (int j = 0; j < n; j++) {
                rows[i] += row[j];
                cols[j] += row[j];
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(rows[i] - cols[j]) <= matrix[i][j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}