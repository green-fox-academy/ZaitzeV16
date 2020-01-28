# # List introduction 1
#
# We are going to play with lists. Feel free to use the built-in methods where
# possible.
#
# - Create an empty list which will contain names (strings)
names = list()

# - Print out the number of elements in the list
print(len(names))

# - Add William to the list
names.append("William")

# - Print out whether the list is empty or not
if names:
    print("not empty")
else:
    print("empty")

# - Add John to the list
names.append("John")

# - Add Amanda to the list
names.append("Amanda")

# - Print out the number of elements in the list
print(len(names))

# - Print out the 3rd element
print(names[2])

# - Iterate through the list and print out each name
#   ```text
#   William
#   John
#   Amanda
#   ```
for name in names:
    print(name)

# - Iterate through the list and print
#   ```text
#   1. William
#   2. John
#   3. Amanda
#   ```
for i in range(len(names)):
    print("{}. {}".format(i + 1, names[i]))

# - Remove the 2nd element
names.pop(1)

# - Iterate through the list in a reversed order and print out each name
#   ```text
#   Amanda
#   William
#   ```
for name in names[::-1]:
    print(name)

# - Remove all elements
names.clear()
