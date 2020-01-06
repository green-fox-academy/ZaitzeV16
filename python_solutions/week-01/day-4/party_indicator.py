# Write a program that asks for two numbers
# The first number represents the number of girls that comes to a party, the
# second the boys
num_of_girls = int(input("girls: "))
num_of_boys = int(input("boys: "))

people = num_of_girls + num_of_boys

# It should print: The party is excellent!
# If the the number of girls and boys are equal and
# 20 or more people are coming to the party
#
# It should print: Quite cool party!
# If there are 20 or more people coming to the party but
# the girl - boy ratio is not 1-1
#
# It should print: Average party...
# If there are less people coming than 20
#
# It should print: Sausage party
# If no girls are coming, regardless the count of the people

if not num_of_girls:
    print("Sausage party")
elif people < 20:
    print("Average party...")
else:
    if num_of_girls != num_of_boys:
        print("Quite cool party!")
    else:
        print("The party is excellent!")
