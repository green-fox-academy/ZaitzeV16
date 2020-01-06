# Write a program that reads a number from the standard input, then draws a
# diamond like this:
#
#
#    *
#   ***
#  *****
# *******
#  *****
#   ***
#    *
#
# The diamond should have as many lines as the number was

user_input = int(input("numma: "))

while user_input % 2 == 0:
    user_input = int(input("odd numma: "))
else:
    for i in range(1, user_input + 1):
        if i <= (user_input + 1) / 2:
            number_of_stars = 2 * i - 1
        else:
            number_of_stars = 2 * (user_input + 1 - i) - 1
        
        print("{}{}{}".format(
            " " * int(((user_input - number_of_stars) / 2)),
            "*" * number_of_stars,
            " " * int(((user_input - number_of_stars) / 2)),
        ))
