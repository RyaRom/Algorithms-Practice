package BracketParsing;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseParentheses("(u(love)i)"));
    }

    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c :s.toCharArray()){
            if (c == ')'){
                List<Character> reversed = new ArrayList<>();
                char t;
                while ((t = stack.pop())!= '(') reversed.add(t);
                stack.addAll(reversed);
            }
            else stack.push(c);
        }
        return stack.stream().map(c->""+c).collect(Collectors.joining());
    }
}