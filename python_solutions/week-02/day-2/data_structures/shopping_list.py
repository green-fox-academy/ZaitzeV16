"""
# Shopping list

We are going to represent a shopping list in a list containing strings.

- Create a list with the following items.
  - Eggs, milk, fish, apples, bread and chicken
- Create an application which solves the following problems.
  - Do we have milk on the list?
  - Do we have bananas on the list?
"""
shopping_items = ["eggs", "milk", "fish", "apples", "bread", "chicken"]
print("Do we have milk on the list?")
print("yes" if shopping_items.__contains__("milk") else "nope, sorry")

print("Do we have bananas on the list?")
print("yes" if shopping_items.__contains__("bananas") else "nope, sorry")
