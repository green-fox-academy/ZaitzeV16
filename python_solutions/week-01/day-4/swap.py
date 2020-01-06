# Swap the values of the variables
a = 123
b = 526

print("a is: {}\nb is: {}\n".format(a, b))

a, b = b, a
print("a is: {}\nb is: {}".format(a, b))
