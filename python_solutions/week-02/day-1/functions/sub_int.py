#  Create a function that takes a number and
#   an array of integers as a parameter
#  Returns the indices of the integers in the array
#   of which the first number is a part of
#  Or returns an empty array if the number is not part
#   of any of the integers in the array


def sub_int(number: int, list_of_numbers: list):
    number = str(number)
    list_of_numbers = list(map(lambda item: str(item), list_of_numbers))
    
    return list(list_of_numbers.index(item) for item in list_of_numbers if
                number in item)


if __name__ == '__main__':
    #  Example:
    print(sub_int(1, [1, 11, 34, 52, 61]))
    #  should print: `[0, 1, 4]`
    print(sub_int(9, [1, 11, 34, 52, 61]))
    #  should print: '[]'
