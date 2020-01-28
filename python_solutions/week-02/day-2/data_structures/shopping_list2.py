"""
# Shopping list 2

- Represent the following products with their prices

  | Product         | Amount |
  | :-------------- | :----- |
  | Milk            | 1.07   |
  | Rice            | 1.59   |
  | Eggs            | 3.14   |
  | Cheese          | 12.60  |
  | Chicken Breasts | 9.40   |
  | Apples          | 2.31   |
  | Tomato          | 2.58   |
  | Potato          | 1.75   |
  | Onion           | 1.10   |
"""
products = {
    "Milk": 1.07,
    "Rice": 1.59,
    "Eggs": 3.14,
    "Cheese": 12.60,
    "Chicken Breasts": 9.40,
    "Apples": 2.31,
    "Tomato": 2.58,
    "Potato": 1.75,
    "Onion": 1.10,
}
"""
- Represent Bob's shopping list
  | Product         | Amount |
  | --------------- | ------ |
  | Milk            | 3      |
  | Rice            | 2      |
  | Eggs            | 2      |
  | Cheese          | 1      |
  | Chicken Breasts | 4      |
  | Apples          | 1      |
  | Tomato          | 2      |
  | Potato          | 1      |
"""
bob = {
    "Milk": 3,
    "Rice": 2,
    "Eggs": 2,
    "Cheese": 1,
    "Chicken Breasts": 4,
    "Apples": 1,
    "Tomato": 2,
    "Potato": 1,
}
"""
- Represent Alice's shopping list
  | Product         | Amount |
  | --------------- | ------ |
  | Rice            | 1      |
  | Eggs            | 5      |
  | Chicken Breasts | 2      |
  | Apples          | 1      |
  | Tomato          | 10     |
"""
alice = {
    "Rice": 1,
    "Eggs": 5,
    "Chicken Breasts": 2,
    "Apples": 1,
    "Tomato": 10,
}
"""
- Create an application which solves the following problems.
  - How much does Bob pay?
  - How much does Alice pay?
  - Who buys more Rice?
  - Who buys more Potato?
  - Who buys more different products?
  - Who buys more products? (piece)
"""
print("How much does Bob pay?")
print(sum(products.get(k) * v for k, v in bob.items()))

print("How much does Alice pay?")
print(sum(products.get(k) * v for k, v in alice.items()))

print("Who buys more Rice?")
print("Bob" if bob.get("Rice") > alice.get("Rice") else "Alice")

print("Who buys more Potato?")
bob_potato = bob.__contains__("Potato")
alice_potato = alice.__contains__("Potato")
if bob_potato:
    if alice_potato:
        print("Bob" if bob.get("Potato") > alice.get("Potato") else "Alice")
    else:
        print("Bob")
elif alice_potato:
    print("Alice")
else:
    print("None of them")

print("Who buys more different products?")
print("Bob" if len(bob) > len(alice) else "Alice")

print("Who buys more products? (piece)")
print("Bob" if sum(bob.values()) > sum(alice.values()) else "Alice")
