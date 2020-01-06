# Write a function called `sum` that returns
# the sum of numbers from zero to the given parameter


def my_sum(number: int):
    if number == 1:
        return 1
    else:
        return number + my_sum(number - 1)


if __name__ == '__main__':
    print(my_sum(5))
