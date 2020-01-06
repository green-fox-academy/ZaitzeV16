# Write a program that reads a number from the standard input, then draws a
# pyramid like this:
#
#
#    *
#   ***
#  *****
# *******
#
# The pyramid should have as many lines as the number was

user_input = int(input("numma: "))

for i in range(1, user_input + 1):
    print("{}{}{}".format(
        " " * (user_input - i),
        "*" * (2 * i - 1),
        " " * (user_input - i),
    ))
