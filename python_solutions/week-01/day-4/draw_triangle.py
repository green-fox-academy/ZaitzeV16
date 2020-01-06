# Write a program that reads a number from the standard input, then draws a
# triangle like this:
#
# *
# **
# ***
# ****
#
# The triangle should have as many lines as the number was

for i in range(1, int(input("numma: ")) + 1):
    print("*" * i)
