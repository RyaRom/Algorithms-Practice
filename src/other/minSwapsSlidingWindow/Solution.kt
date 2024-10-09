package other.minSwapsSlidingWindow;


class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minSwaps(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0}));
    }

    public int minSwaps(int[] nums) {
        int one = 0;
        int[] numsCircular = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) one++;
            numsCircular[i] = nums[i];
        }
        if (nums.length + one - nums.length >= 0)
            System.arraycopy(nums, 0, numsCircular, nums.length, nums.length + one - nums.length);
        int p1 = 0;
        int p2 = one;
        int current = 0;
        int minSwap = 100001;
        for (int i = 0; i < one; i++) if (numsCircular[i] == 0) current++;
        for (int i = 0; i < nums.length; i++) {
            p1++;
            p2++;
            if (numsCircular[p1 - 1] == 0) current--;
            if (numsCircular[p2 - 1] == 0) current++;
            minSwap = Math.min(minSwap, current);
        }
        return minSwap;
    }
}
