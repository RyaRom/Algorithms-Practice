package LuckyMatrix;

import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> rowMin = Arrays.stream(matrix).map(a-> Arrays.stream(a).min().getAsInt()).toList();
        int[][] reversed=  new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                reversed[j][i] = matrix[i][j];
            }
        }
        List<Integer> columnMax = Arrays.stream(reversed).map(a-> Arrays.stream(a).max().getAsInt()).toList();
        return rowMin.stream().filter(columnMax::contains).toList();
    }
}