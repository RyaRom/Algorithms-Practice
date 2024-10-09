before_100_total_payment = int(input())
after_100_for_each_payment = int(input())
gb_count = int(input())

if gb_count < 100:
    print(before_100_total_payment)
else:
    print(before_100_total_payment + (gb_count - 100) * after_100_for_each_payment)
