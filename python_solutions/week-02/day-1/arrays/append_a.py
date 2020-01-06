# - Create an array variable named `animals`
#   with the following content: `["koal", "pand", "zebr"]`
# - Add all elements an `"a"` at the end

animals = ["koal", "pand", "zebr"]
print(animals)

animals = list(map(lambda animal: animal + "a", animals))
print(animals)
