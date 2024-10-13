import heapq
from typing import List


class Solution:
    def smallestRange(self, nums: List[List[int]]) -> List[int]:
        min_heap = []
        max_value = float('-inf')
        for i in range(len(nums)):
            heapq.heappush(min_heap, (nums[i][0], i, 0))
            max_value = max(max_value, nums[i][0])

        min_range_start, min_range_end = float('-inf'), float('inf')
        while min_heap:
            min_value, list_idx, elem_idx = heapq.heappop(min_heap)

            if max_value - min_value < min_range_end - min_range_start:
                min_range_start, min_range_end = min_value, max_value

            if elem_idx + 1 < len(nums[list_idx]):
                next_value = nums[list_idx][elem_idx + 1]
                heapq.heappush(min_heap, (next_value, list_idx, elem_idx + 1))
                max_value = max(max_value, next_value)
            else:
                break

        return [min_range_start, min_range_end]


print(Solution().smallestRange([[1, 2, 3], [1, 2, 3], [1, 2, 3]]))
