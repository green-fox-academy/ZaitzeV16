# - Create a function called `factorio`
#   that returns it's input's factorial


def factorio(number: int):
    if number == 1:
        return 1
    else:
        return number * factorio(number - 1)


if __name__ == '__main__':
    print(factorio(5))
