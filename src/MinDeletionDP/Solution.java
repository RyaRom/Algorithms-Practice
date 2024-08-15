package minDeletionDP;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumDeletions("aababbab"));
    }
    public int minimumDeletions(String s) {
        int minDeletion;
        int[][] table = new int[s.length()][2];
        int t = 0;
        char[] string= s.toCharArray();
        for (int i = 1; i < string.length; i++) {
            if (string[i] == 'a')t++;
        }
        table[0] = new int[]{0,t};
        minDeletion = t;
        for (int i = 1; i < string.length; i++) {
            int[] prev = table[i-1];
            int left = prev[0] + (string[i-1]=='b'?1:0);
            int right = prev[1] - (string[i]=='a'?1:0);
            minDeletion = Math.min(minDeletion, left+right);
            table[i] = new int[]{left,right};
        }
        return minDeletion;
    }
}
