# Write a program that reads a number from the standard input, then draws a
# square like this:
#
#
# %%%%%%
# %    %
# %    %
# %    %
# %    %
# %%%%%%
#
# The square should have as many lines as the number was

user_input = int(input("numma: "))

while user_input < 1:
    user_input = int(input("bigga numma: "))
else:
    for i in range(1, user_input + 1):
        number_of_percentages = user_input if i in (1, user_input) else 2
        
        if number_of_percentages == user_input:
            print("%" * number_of_percentages)
        else:
            print("%{}%".format(" " * (user_input - number_of_percentages)))
