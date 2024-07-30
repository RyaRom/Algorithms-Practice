package ThreeIncreasingNumbers;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numTeams(new int[]{2,5,3,4,1}));
    }
    public int numTeams(int[] rating) {
        int ans = 0;
        for(int i = 1; i < rating.length - 1; i++) {
            int smallLeft = 0, bigLeft = 0, smallRight = 0, bigRight = 0;
            for(int j = 0; j < i; j++) {
                if(rating[j] < rating[i]) smallLeft++;
                if(rating[j] > rating[i]) bigLeft++;
            }

            for(int j = i+1; j < rating.length; j++) {
                if(rating[j] > rating[i]) bigRight++;
                if(rating[j] < rating[i]) smallRight++;
            }

            ans += (smallLeft * bigRight) + (bigLeft * smallRight);

        }

        return ans;
    }

}