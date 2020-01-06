# Write a program that asks for a number.
# It would ask this many times to enter an integer,
# if all the integers are entered,
# it should print the sum and average of these
# integers like:
#
# Sum: 22, Average: 4.4

_sum = 0
number_of_inputs = int(input("number of numbers... hehe: "))

for i in range(number_of_inputs):
    _sum += int(input("number {}: ".format(i + 1)))

print("sum: {}, average: {:.1f}".format(_sum, _sum / number_of_inputs))
