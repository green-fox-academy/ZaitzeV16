import math

a = 3  # make the "a" variable's value bigger by 10
a += 10
print(a)

b = 100  # make b smaller by 7
b -= 7
print(b)

c = 44  # please double c's value
c *= 2
print(c)

d = 125  # please divide by 5 d's value
d /= 5
print(int(d))

e = 8  # please cube of e's value
e = math.pow(e, 2)
print(int(e))

f1 = 123
f2 = 345  # tell if f1 is bigger than f2 (print as a boolean)
print(f1 > f2)

g1 = 350
g2 = 200  # tell if the double of g2 is bigger than g1 (print as a boolean)
print(g2 * 2 > g1)

h = 135798745  # tell if it has 11 as a divisor (print as a boolean)
print(h % 11 == 0)

i1 = 10
i2 = 3  # tell if i1 is higher than i2 squared and smaller than
        # i2 cubed (print as a boolean)
print(math.pow(i2, 2) < i1 < math.pow(i2, 3))

j = 1521  # tell if j is dividable by 3 or 5 (print as a boolean)
print("by 3: {}\n"
      "by 5: {}".format((1521 % 3 == 0), (1521 % 3 == 5)))
