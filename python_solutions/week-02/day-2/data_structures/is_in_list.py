# Check if list contains all of the following elements: 4,8,12,16
# Create a function that accepts list_of_numbers as an input
# it should return "True" if it contains all, otherwise "False"

list_of_numbers = [2, 4, 6, 8, 10, 12, 14, 16]


def check_nums(list_of_numbers: list):
    numbers_to_check = [4, 8, 12, 16]
    for number in numbers_to_check:
        if not list_of_numbers.__contains__(number):
            return False
    return True


if __name__ == '__main__':
    print(check_nums(list_of_numbers))
