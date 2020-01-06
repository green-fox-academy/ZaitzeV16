# Exercise
#
# Create a function named create_palindrome following your current language's
# style guide. It should take a string, create a palindrome from it and then
# return it.
#
# Examples
#
# |    input   |       output       |
# | :--------: | :----------------: |
# |     ""     |         ""         |
# | "greenfox" | "greenfoxxofneerg" |
# |    "123"   |      "123321"      |


def create_palindrome(string: str):
    return string + string[::-1]


if __name__ == '__main__':
    print(create_palindrome("greenfox"))
    print(create_palindrome("123"))
