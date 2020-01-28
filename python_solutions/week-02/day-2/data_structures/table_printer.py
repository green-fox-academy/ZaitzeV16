# Create a function that prints the ingredient list of dictionaries to the
# console in the following format:
#
# +--------------------+---------------+----------+
# | Ingredient         | Needs cooling | In stock |
# +--------------------+---------------+----------+
# | vodka              | Yes           | 1        |
# | coffee_liqueur     | Yes           | -        |
# | fresh_cream        | Yes           | 1        |
# | captain_morgan_rum | Yes           | 2        |
# | mint_leaves        | No            | -        |
# +--------------------+---------------+----------+
#
# OPTIONAL:
# The first columns should be automatically as wide as the longest key

ingredients = [
    {"name": "vodka", "in_stock": 1, "needs_cooling": True},
    {"name": "coffee_liqueur", "in_stock": 0, "needs_cooling": True},
    {"name": "fresh_cream", "in_stock": 1, "needs_cooling": True},
    {"name": "captain_morgan_rum", "in_stock": 2, "needs_cooling": True},
    {"name": "mint_leaves", "in_stock": 0, "needs_cooling": False},
    {"name": "sugar", "in_stock": 0, "needs_cooling": False},
    {"name": "lime juice", "in_stock": 0, "needs_cooling": True},
    {"name": "soda", "in_stock": 0, "needs_cooling": True}
]
longest_name = max(
    map(lambda x: len(x.get("name")), ingredients)
)

table = list()
separator = "+" + \
            "-" * (longest_name + 2) + \
            "+" + \
            "-" * (len("Needs cooling") + 2) + \
            "+" + \
            "-" * (len("In stock") + 2) + \
            "+"

table.append(separator)
table.append(
    "| {:{}} ".format("Ingredient", longest_name) +
    "| {:{}} ".format("Needs cooling", len("Needs cooling")) +
    "| {:{}} |".format("In stock", len("In stock"))
)
table.append(separator)

for ingredient in ingredients:
    cooling = "Yes" if ingredient.get("needs_cooling") else "No"
    stock = str(ingredient.get("in_stock")) if ingredient.get(
        "in_stock") else "-"
    
    output_line = "| {:{}} ".format(ingredient.get("name"), longest_name) + \
                  "| {:{}} ".format(cooling, len("Needs cooling")) + \
                  "| {:{}} |".format(stock, len("In stock"))
    table.append(output_line)
    
    # print(output_line)

table.append(separator)
print("\n".join(table))

if __name__ == '__main__':
    pass
