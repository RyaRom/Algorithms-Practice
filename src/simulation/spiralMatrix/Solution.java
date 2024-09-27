package simulation.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        new Solution().spiralPrint(new int[][]{
                {1,2,3,4}}, 0,0);
    }
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] matrix = new int[rows][cols];
        return listToArray(spiralPrint(matrix, rStart, cStart));
    }
    public static int[][] listToArray(List<int[]> list) {
        // Create a new int[][] array with the same size as the List<int[]>
        int[][] array = new int[list.size()][];

        // Copy each element from the list to the array
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }
    private List<int[]> spiralPrint(int[][]matrix, int rStart, int cStart){
        List<int[]> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int dir = 0;
        int steps = 1;
        int r = rStart;
        int c = cStart;

        result.add(new int[]{r,c});

        while (result.size() < rows * cols) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < steps; j++) {
                    r += dr[dir];
                    c += dc[dir];

                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result.add(new int[]{r,c});
                    }
                }
                dir = (dir + 1) % 4;
            }
            steps++;
        }
        return result;
    }
}