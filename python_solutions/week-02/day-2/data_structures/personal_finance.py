"""
# Personal finance

We are going to represent our expenses in a list containing integers.

- Create a list with the following items.
  - 500, 1000, 1250, 175, 800 and 120
- Create an application which solves the following problems.
  - How much did we spend?
  - Which was our greatest expense?
  - Which was our cheapest spending?
  - What was the average amount of our spendings?
"""
expenses = [500, 1000, 1250, 175, 800, 120]
print("We spent : {}".format(sum(expenses)))
print("Our greatest expense was: {}".format(max(expenses)))
print("Our cheapest spending was: {}".format(min(expenses)))
print("We spent {:.2f} in average".format(max(expenses) / len(expenses)))
