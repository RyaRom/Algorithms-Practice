from typing import List


class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        events = []
        for interval in intervals:
            events.append([interval[0], 1])
            events.append([interval[1] + 1, -1])
        events = sorted(events, key=lambda x: (x[0], x[1]))
        max_sum = 0
        sum_pref = 0
        for event in events:
            sum_pref += event[1]
            max_sum = max(max_sum, sum_pref)
        return max_sum


print(Solution().minGroups([[5, 10], [6, 8], [1, 5], [2, 3], [1, 10]]))
