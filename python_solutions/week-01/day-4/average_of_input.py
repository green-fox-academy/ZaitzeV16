# Write a program that asks for 5 integers in a row,
# then it should print the sum and the average of these numbers like:
#
# Sum: 22, Average: 4.4

_sum = 0
number_of_inputs = 5

for i in range(number_of_inputs):
    _sum += int(input("number {}: ".format(i + 1)))

print("sum: {}, average: {:.1f}".format(_sum, _sum / number_of_inputs))
