package greedy.distinctString;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().kthDistinct(new String[]{"d","b","c","b","c","a"}, 2));
    }
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String s : arr) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
        int i = 0;
        for (String s : arr) {
            if (freq.get(s)>1)continue;
            if (i==k)return s;
            i++;
            if (i==k)return s;
        }
        return "";
    }
}