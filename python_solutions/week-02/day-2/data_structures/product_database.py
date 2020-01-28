"""
# Product database

We are going to represent our products in a map where the keys are strings
representing the product's name and the values are numbers representing the
product's price.

- Create a map with the following key-value pairs.

  | Product name (key) | Price (value) |
  | :----------------- | :------------ |
  | Eggs               | 200           |
  | Milk               | 200           |
  | Fish               | 400           |
  | Apples             | 150           |
  | Bread              | 50            |
  | Chicken            | 550           |

- Create an application which solves the following problems.
  - [How much is the fish?](https://www.youtube.com/watch?v=cbB3iGRHtqA)
  - What is the most expensive product?
  - What is the average price?
  - How many products' price is below 300?
  - Is there anything we can buy for exactly 125?
  - What is the cheapest product?
"""
products = {
    "Eggs": 200,
    "Milk": 200,
    "Fish": 400,
    "Apples": 150,
    "Bread": 50,
    "Chicken": 550,
}

print("How much is the fish?")
print(products.get("Fish"))

print("What is the most expensive product?")
print(max(products, key=products.get))

print("What is the average price?")
print("{:.2f}".format((sum(products.values()) / len(products.values()))))

print("How many products' price is below 300?")
print(len(list(filter(lambda x: x < 300, products.values()))))

print("Is there anything we can buy for exactly 125?")
print("yes" if len(
    list(filter(lambda x: x == 125, products.values()))) else "nope, sorry")

print("What is the cheapest product?")
print(min(products, key=products.get))
