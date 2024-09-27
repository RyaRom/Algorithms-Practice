package backtracking.backtrackingCombinationSum2;

import java.util.*;

public class Solution {
    private final List<List<Integer>> combinations = new ArrayList<>();
    private final Set<List<Integer>> seen = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{2,5,2,1,2}, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(0, target, candidates, new ArrayList<>());
        return combinations;
    }

    private void backtracking(int start, int target, int[] candidates, ArrayList<Integer> path) {
        if (target == 0) {
            if (seen.add(new ArrayList<>(path))) {
                combinations.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(i + 1, target - candidates[i], candidates, path);
            path.removeLast();
        }
    }
}