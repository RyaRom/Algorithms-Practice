package simulation.subarraySorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5));
    }

    private long sum(int s, int f, int[] arr) {
        long sum = 0;
        for (int i = s; i <= f; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private long sum(int s, int f, List<Long> arr) {
        long sum = 0;
        for (int i = s; i <= f; i++) {
            sum += arr.get(i);
        }
        return sum;
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Long> subArrays = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                subArrays.add(sum(i, j, nums));
            }
        }
        Collections.sort(subArrays);
        return (int) (sum(left - 1, right - 1, subArrays) % (1000000000 + 7));
    }
}