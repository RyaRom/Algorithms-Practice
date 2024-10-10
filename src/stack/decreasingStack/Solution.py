from typing import List


class Solution:
    def maxWidthRamp(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        stack = [0]
        for i in range(1, len(nums)):
            if nums[i] < nums[stack[-1]]:
                stack.append(i)
        max_size = 0
        index = len(nums) - 1
        while stack and index >= 0:
            if nums[stack[-1]] <= nums[index]:
                max_size = max(max_size, index - stack[-1])
                stack.pop()
            else:
                index -= 1
        return max_size


print(Solution().maxWidthRamp([9, 8, 1, 0, 1, 9, 4, 0, 4, 1]))
