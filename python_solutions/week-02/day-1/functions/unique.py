#  Create a function that takes a list of numbers as a parameter
#  Returns a list of numbers where every number in the list occurs only once


def unique(list_of_nums: list):
    print(list_of_nums)
    return sorted(list(set(list_of_nums)))


if __name__ == '__main__':
    #  Example
    print(unique([1, 11, 34, 11, 52, 61, 1, 34]))
    #  should print: `[1, 11, 34, 52, 61]`
