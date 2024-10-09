_str = input()
m = False
t = False
s = False
for ch in _str:
    if ch == 'M' or ch == 'm':
        m = True
    if (ch == 'T' or ch == 't') and m:
        t = True
    if (ch == 'S' or ch == 's') and t:
        s = True
if m and t and s:
    print(1)
else:
    print(0)
