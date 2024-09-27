package other.magicSquareSW;

class Solution {
    private final int[][][] magicSquares = new int[][][]{
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
    };

    public static void main(String[] args) {
        System.out.println(new Solution().numMagicSquaresInside(new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}}));
    }

    public int numMagicSquaresInside(int[][] grid) {
        int c = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[i].length - 2; j++) {
                if (check(grid, i, j)) c++;
            }
        }
        return c;
    }

    private boolean check(int[][] matrix, int a, int b) {
        checkSquare:
        for (int[][] magicSquare : magicSquares) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matrix[a + i][b + j] != magicSquare[i][j]) {
                        continue checkSquare;
                    }
                }
            }
            return true;
        }
        return false;
    }
}