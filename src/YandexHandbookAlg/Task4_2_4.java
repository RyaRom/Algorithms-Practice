package YandexHandbookAlg;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task4_2_4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = s.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] += s.nextInt();
            }
        }
        System.out.println(Arrays.stream(matrix).map(row-> Arrays.stream(row).mapToObj(Objects::toString).collect(Collectors.joining(" "))).collect(Collectors.joining("\n")));;
    }
}
