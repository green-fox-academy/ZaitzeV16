# - Create an array variable named `numList`
#   with the following content: `[3, 4, 5, 6, 7]`
# - Double all the values in the array

num_list = [3, 4, 5, 6, 7]
print(num_list)

num_list = list(map(lambda x: x * 2, num_list))
print(num_list)
