package BacktrackingCombinationSum3;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 7));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> nums = new ArrayList<>();
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(0, n, nums, combinations, k);
        return combinations;
    }

    private void backtracking(int n, int sum, List<Integer> numbers, List<List<Integer>> arrays, int k) {
        if (sum == 0 && numbers.size() == k) {
            arrays.add(new ArrayList<>(numbers));
            return;
        }
        if (sum < 0 || numbers.size() >= k) {
            return;
        }
        for (int i = n + 1; i <= Math.min(sum, 9); i++) {
            List<Integer> combination = new ArrayList<>(numbers);
            combination.add(i);
            backtracking(i, sum - i, combination, arrays, k);
        }
    }
}