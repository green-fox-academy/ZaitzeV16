# Exercise
# Create a function named is_anagram following your current language's style
# guide. It should take two strings and return a boolean value depending on
# whether its an anagram or not.

# Examples
# | input 1 | input 2 | output |
# | :-----: | :-----: | :----: |
# |  "dog"  |  "god"  |  true  |
# | "green" |  "fox"  |  false |


def are_anagrams(string_1: str, string_2: str):
    intersection = set(list(string_1)).intersection(set(list(string_2)))
    return True if len(intersection) is len(string_1) and \
                   len(intersection) is len(string_2) else False


if __name__ == '__main__':
    print(are_anagrams("dog", "god"))
    print(are_anagrams("green", "fox"))
    print(are_anagrams("asd", "dfg"))
