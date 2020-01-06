# - Create an integer variable named `baseNum` and assign the value `123` to it
# - Create a function called `doubling` that doubles
#   it's input parameter and returns with an integer
# - Print the result of `doubling(baseNum)`

base_num = 123


def doubling(number: (int, float)):
    return number * 2


if __name__ == '__main__':
    print(doubling(base_num))
