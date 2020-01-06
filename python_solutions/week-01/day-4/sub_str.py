import re


# Create a function that takes two strings as a parameter
#  Returns the starting index where the second one is starting in the first one
#  Returns `-1` if the second string is not in the first one


def sub_str(string: str, pattern: str):
    match = re.compile(pattern).search(string)
    return match.start() if match else -1


if __name__ == '__main__':
    # Example:
    #  should print: `17`
    print(sub_str("this is what I'm searching in", "searching"))
    
    #  should print: `-1`
    print(sub_str("this is what I'm searching in", "not"))
