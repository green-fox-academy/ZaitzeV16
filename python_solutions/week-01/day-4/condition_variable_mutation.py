a = 24
out = 0
# if a is even increment out by one
if 24 % 2 == 0:
    out += 1
print(out)

b = 13
out2 = ""
# if b is between 10 and 20 set out2 to "Sweet!"
# if less than 10 set out2 to "Less!",
# if more than 20 set out2 to "More!"
if b < 10:
    out2 = "Less!"
elif 10 < b < 20:
    out2 = "Sweet!"
elif b > 20:
    out2 = "More!"
print(out2)

c = 123
_credits = 100
is_bonus = False
# if credits are at least 50,
# and isBonus is false decrement c by 2
# if credits are smaller than 50,
# and isBonus is false decrement c by 1
# if isBonus is true c should remain the same
if not is_bonus:
    if _credits >= 50:
        c -= 2
    elif _credits < 50:
        c -= 2
print(c)

d = 8
time = 120
# out3 = ""
out3 = "Run Forest Run!"
# if d is dividable by 4
# and time is not more than 200
# set out3 to "check"
# if time is more than 200
# set out3 to "Time out"
# otherwise set out3 to "Run Forest Run!"
if time > 200:
    out3 = "Time out"
else:
    if d % 4 == 0:
        out3 = "check"
print(out3)
