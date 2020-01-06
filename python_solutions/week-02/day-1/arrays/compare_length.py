# - Create an array variable named `p1`
#   with the following content: `[1, 2, 3]`
# - Create an array variable named `p2`
#   with the following content: `[4, 5]`
# - Print "p2 is longer" if `p2` has more elements than `p1`

p1 = [1, 2, 3]
p2 = [4, 5]

message = "p2 is longer" if len(p2) > len(p1) else "p1 is longer"

print(message)
