n = int(input())
connections = [int(input()) for _ in range(n)]
_sum = sum(connections)
if _sum % 2 == 0:
    print(1)
else:
    print(0)
