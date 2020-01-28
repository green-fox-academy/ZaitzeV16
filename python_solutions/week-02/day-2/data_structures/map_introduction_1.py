# # Map introduction 1
#
# We are going to play with maps. Feel free to use the built-in methods where
# possible.
#
# - Create an empty map where the keys are integers
# and the values are characters
letters = dict()

# - Print out whether the map is empty or not
if letters:
    print("not empty""")
else:
    print("empty")

# - Add the following key-value pairs to the map
#
#   | Key | Value |
#   | :-- | :---- |
#   | 97  | a     |
#   | 98  | b     |
#   | 99  | c     |
#   | 65  | A     |
#   | 66  | B     |
#   | 67  | C     |
#
letters[97] = "a"
letters[98] = "b"
letters[99] = "c"
letters[65] = "A"
letters[66] = "B"
letters[67] = "C"

# - Print all the keys
print(letters.keys())

# - Print all the values
print(letters.values())

# - Add value D with the key 68
letters[68] = "D"

# - Print how many key-value pairs are in the map
print(len(letters.items()))

# - Print the value that is associated with key 99
print(letters[99])

# - Remove the key-value pair where with key 97
letters.pop(97)

# - Print whether there is an associated value with key 100 or not
if letters.get(100):
    print("yepp")
else:
    print("nope")

# - Remove all the key-value pairs
letters.clear()