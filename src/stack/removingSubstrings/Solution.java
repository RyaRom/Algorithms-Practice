package stack.removingSubstrings;

import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumGain("cdbcbbaaabab", 4, 5));
    }

    public int maximumGain(String s, int x, int y) {
        boolean abIsBetter = x > y;
        Stack<Character> stack = new Stack<>();
        int points = 0;
        if (abIsBetter) {
            points = getPointsAB(s, x, stack, points);
            s = stack.stream().map(c -> "" + c).collect(Collectors.joining());
            stack.clear();
            points = getPointsBA(s, y, stack, points);
        } else {
            points = getPointsBA(s, y, stack, points);
            s = stack.stream().map(c -> "" + c).collect(Collectors.joining());
            stack.clear();
            points = getPointsAB(s, x, stack, points);
        }
        return points;
    }

    private int getPointsBA(String s, int y, Stack<Character> stack, int points) {
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == 'a' && stack.peek() == 'b') {
                stack.pop();
                points += y;
            } else stack.push(c);
        }
        return points;
    }

    private int getPointsAB(String s, int x, Stack<Character> stack, int points) {
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == 'b' && stack.peek() == 'a') {
                stack.pop();
                points += x;
            } else stack.push(c);
        }
        return points;
    }
}
