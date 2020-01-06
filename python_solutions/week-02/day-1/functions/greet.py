# - Create a string variable named `al` and assign the value `Green Fox` to it
# - Create a function called `greet` that greets it's input parameter
#     - Greeting is printing e.g. `Greetings dear, Green Fox`
# - Greet `al`

al = "Green Fox"


def greet(name: str):
    print("Greetings dear, {}".format(name))


if __name__ == '__main__':
    greet(al)
