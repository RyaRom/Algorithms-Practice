package ReversedSubarrays;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length!=arr.length)return false;
        Map<Integer, Integer> targetMap = new HashMap();
        Map<Integer, Integer> arrMap = new HashMap();
        for (int j : target) targetMap.put(j, targetMap.get(j)==null?1:targetMap.get(j)+1);
        for (int j : arr) arrMap.put(j, arrMap.get(j)==null?1:arrMap.get(j)+1);
        return targetMap.equals(arrMap);
    }
}
