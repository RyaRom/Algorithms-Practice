package MappingAndSorting;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortJumbled(new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6}, new int[]{0, 338, 38})));
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<String, Integer> newNums = new HashMap<>();
        HashMap<Integer, Integer> numsCost = new HashMap<>();
        for (int i = 0; i < mapping.length; i++) {
            newNums.put(i + "", mapping[i]);
        }
        for (int k : nums) {
            String num = String.valueOf(k);
            StringBuilder newNum = new StringBuilder();
            char[] chars = num.toCharArray();
            int p = 0;
            if (chars.length != 1 || chars[0] != '0') {
                for (char c : chars) {
                    if (c != '0') break;
                    p++;
                }
            }
            for (int j = p; j < chars.length; j++) {
                newNum.append(newNums.get(String.valueOf(chars[j])));
            }
            numsCost.put(k, Integer.parseInt(newNum.toString()));
        }
        List<Integer> temp = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        temp.sort(Comparator.comparingInt(numsCost::get));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp.get(i);
        }
        return nums;
    }
}