# Write a program that reads a number from the standard input, then draws a
# square like this:
#
#
# %%%%%
# %%  %
# % % %
# %  %%
# %%%%%
#
# The square should have as many lines as the number was

user_input = int(input("numma: "))

while user_input < 1:
    user_input = int(input("bigga numma: "))
else:
    for i in range(1, user_input + 1):
        if i in (1, user_input):
            print("%" * user_input)
            continue
        else:
            line = ""
            for j in range(1, user_input + 1):
                if j in (1, i, user_input):
                    line += "%"
                else:
                    line += " "
            else:
                print(line)
