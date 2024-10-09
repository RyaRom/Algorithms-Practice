class Solution:
    def min_add_to_make_valid(self, s: str) -> int:
        stack = []
        for ch in s:
            if ch == ')':
                if stack and stack[-1] == '(':
                    stack.pop()
                else:
                    stack.append(ch)
            else:
                stack.append(ch)

        return len(stack)


sol = Solution()
print(sol.min_add_to_make_valid("()))(("))
