# # List introduction 2
#
# - Create a list ('`List A`') which contains the following values
#   ```text
#   Apple, Avocado, Blueberries, Durian, Lychee
#   ```
fruits = ["Apple", "Avocado", "Blueberries", "Durian", "Lychee"]

# - Create a new list ('`List B`') with the values of `List A`
new_fruits = fruits.copy()

# - Print out whether `List A` contains Durian or not
print("contains Durian" if "Durian" in fruits else "not containing")

# - Remove Durian from `List B`
new_fruits.remove("Durian")

# - Add Kiwifruit to `List A` after the 4th element
fruits.insert(4, "Kiwifruit")

# - Compare the size of `List A` and `List B`
print(len(fruits) == len(new_fruits))

# - Get the index of Avocado from `List A`
print(fruits.index("Avocado"))

# - Get the index of Durian from `List B`
print(fruits.index("Durian"))

# - Add Passion Fruit and Pomelo to `List B` in a single statement
new_fruits = new_fruits + ["Passion Fruit", "Pomelo"]

# - Print out the 3rd element from `List A`
print(fruits[2])
