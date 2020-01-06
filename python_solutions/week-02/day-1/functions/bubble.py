#  Create a function that takes a list of numbers as parameter
#  Returns a list where the elements are sorted in ascending numerical order
#  Make a second boolean parameter, if it's `true` sort that list descending


def bubble(list_to_order: list, reversed=False):
    return sorted(list_to_order) if not reversed else sorted(list_to_order,
                                                             reverse=True)


if __name__ == '__main__':
    #  Example:
    print(bubble([34, 12, 24, 9, 5]))
    #  should print [5, 9, 12, 24, 34]
    print(bubble([34, 12, 24, 9, 5], True))
    #  should print [34, 24, 12, 9, 5]
