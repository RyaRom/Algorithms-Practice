package sortByFrequency;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().frequencySort(new int[]{2, 3, 1, 3, 2})));
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        Arrays.stream(nums).boxed().forEach(i->freq.put(i, freq.getOrDefault(i,0)+1));
        Object[] fr = freq.keySet().stream().sorted((o1, o2) -> {
            int res=  Integer.compare(freq.get(o1), freq.get(o2));
            if (res ==0){
                return Integer.compare(o2,o1);
            }
            return res;
        }).toArray();
        int p = 0;
        for (Object key: fr){
            int len = freq.get(key) + p;
            for (int i = p; i < len; i++) {
                nums[i] = (int) key;
                p++;
            }
        }
        return nums;
    }
}
