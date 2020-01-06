# - Create a string variable named `typo`
#   and assign the value `Chinchill` to it
# - Write a function called `appendAFunc` that gets a string as an input,
#   appends an 'a' character to its end and returns with a string
#
# - Print the result of `appendAFunc(typo)`

typo = "Chinchill"


def append_a_func(need_a: str):
    return need_a + "a"


if __name__ == '__main__':
    print(append_a_func(typo))
