package stack.atomParse;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    private final Pattern pattern = Pattern.compile("[A-Z][a-z]*|\\d+|[)(]");

    private final Map<String, Integer> elements = new TreeMap<>(String::compareTo);

    public static void main(String[] args) {
        System.out.println(new Solution().countOfAtoms("Mg(H2(O))2"));
    }

    private void addElement(int elementsCount, Stack<String> parsed) {
        String next = parsed.pop();
        if (next.matches("[A-Z][a-z]*")) {
            elements.put(next, elements.get(next) == null ? elementsCount : elements.get(next) + elementsCount);
        } else if (next.matches("\\)")) {
            recursiveBracketsCount(parsed, elementsCount);
        }
    }

    private void recursiveBracketsCount(Stack<String> parsed, int multiplicator) {
        while (!parsed.isEmpty()) {
            String current = parsed.pop();
            if (current.matches("\\d+")) {
                int elementsCount = Integer.parseInt(current) * multiplicator;
                addElement(elementsCount, parsed);
            } else if (current.matches("\\(")) {
                return;
            } else if (current.matches("[A-Z][a-z]*")) {
                elements.put(current, elements.get(current) == null ? multiplicator : elements.get(current) + multiplicator);
            } else if (current.matches("\\)")) {
                recursiveBracketsCount(parsed, multiplicator);
            } else {
                throw new RuntimeException("unexpected");
            }
        }
    }

    public String countOfAtoms(String formula) {
        Matcher matcher = pattern.matcher(formula);
        Stack<String> parsed = new Stack<>();
        while (matcher.find()) {
            parsed.push(matcher.group());
        }

        while (!parsed.isEmpty()) {
            String current = parsed.pop();
            if (current.matches("\\d+")) {
                int elementsCount = Integer.parseInt(current);
                addElement(elementsCount, parsed);
            }
            else if (current.matches("[A-Z][a-z]*")) {
                elements.put(current, elements.get(current) == null ? 1 : elements.get(current) + 1);
            } else if (current.matches("\\)")) {
                recursiveBracketsCount(parsed, 1);
            } else {
                throw new RuntimeException("unexpected");
            }
        }
        StringBuilder sb = new StringBuilder();
        elements.forEach((k, v) -> sb.append(k).append(v == 1 ? "" : v));
        return sb.toString();
    }
}