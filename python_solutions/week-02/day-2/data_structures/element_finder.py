# Write a function that checks if the list contains "7" if it contains
# return "Hoorray" otherwise return "Noooooo"

# The output should be: "Noooooo"
# Do this again with a different solution using different list functions!
numbers = [1, 2, 3, 4, 5, 6, 8]


def contains_seven(numbers):
    return "Hoorray" if numbers.__contains__(7) else "Noooooo"


if __name__ == '__main__':
    print(contains_seven(numbers))
