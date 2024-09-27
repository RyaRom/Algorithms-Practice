package greedy.keyMapping;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumPushes("alporfmdqsbhncwyu"));
    }

    public int minimumPushes(String word) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : word.toCharArray()) {
            freq.put(c, (freq.get(c) == null ? 0 : freq.get(c)) + 1);
        }
        List<Map.Entry<Character, Integer>> sorted = freq.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList();
        int count = 0;
        int i = 0;
        int currentVal = 1;
        for (var en : sorted) {
            if (i < 8) {
                freq.put(en.getKey(), currentVal);
                i++;
            } else {
                currentVal++;
                freq.put(en.getKey(), currentVal);
                i = 1;
            }
        }
        for (char c : word.toCharArray()) {
            count += freq.get(c);
        }
        return count;
    }
}