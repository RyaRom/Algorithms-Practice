package YandexHandbookAlg;

import java.util.Scanner;

public class Task8_3_1 {
    public static void main(String[] args) {
        Scanner s=  new Scanner(System.in);
        String a = s.nextLine();
        String b = s.nextLine();
        int[][] table = editDistance(a.toCharArray(), b.toCharArray());
        /*for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + "  ");
            }
            System.out.println();
        }*/
        System.out.println(table[table.length-1][table[table.length-1].length-1]);
    }

    private static int[][] editDistance(char[] A, char[] B){
        int[][] table = new int[A.length+1][B.length+1];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (i ==0 || j==0) table[i][j] = Math.max(i,j);
            }
        }

        for (int i = 1; i < A.length+1; i++) {
            for (int j = 1; j < B.length+1; j++) {
                int insert = table[i][j-1] + 1;
                int delete = table[i-1][j] + 1;
                int replace = table[i-1][j-1] + 1;
                int noChange = table[i-1][j-1];
                if (A[i-1] == B[j-1]) table[i][j] = Math.min(insert, Math.min(delete, noChange));
                else table[i][j] = Math.min(insert, Math.min(delete, replace));
            }
        }
        return table;
    }
}
