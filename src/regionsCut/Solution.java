package regionsCut;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().regionsBySlashes(new String[]{
                "//",
                "//"}));
    }
    public int regionsBySlashes(String[] grid) {
        HashMap<Character, int[][]> grids= new HashMap<>();
        grids.put('/', new int[][]{
                {0,0,1},
                {0,1,0},
                {1,0,0}});
        grids.put('\\', new int[][]{
                {1,0,0},
                {0,1,0},
                {0,0,1}});
        grids.put(' ', new int[][]{
                {0,0,0},
                {0,0,0},
                {0,0,0}});
        int[][] matrix= new int[grid.length*3][grid.length*3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int[][] m = grids.get(grid[i].charAt(j));
                for (int k = 0; k < 3; k++) {
                    System.arraycopy(m[k], 0, matrix[i * 3 + k], j * 3, 3);
                }
            }
        }

        int n = 2;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    paint(i, j, n, matrix);
                    n++;
                }
            }
        }
        return n-2;
    }
    private static void paint(int i, int j, int n, int[][] matrix){
        if (i<0 || i>=matrix.length|| j<0||j>=matrix.length || matrix[i][j]!=0)return;
        matrix[i][j]=n;
        paint(i+1,j,n,matrix);
        paint(i,j+1,n,matrix);
        paint(i,j-1,n,matrix);
        paint(i-1,j,n,matrix);
    }
}
