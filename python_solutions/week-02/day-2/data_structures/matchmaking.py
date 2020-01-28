import itertools

# Write function that joins the two lists by matching one girl with one boy
# in a new list
# If someone has no pair, he/she should be the element of the list too
# Expected output: ["Eve", "Joe", "Ashley", "Fred"...]

girls = ["Eve", "Ashley", "Claire", "Kat", "Jane"]
boys = ["Joe", "Fred", "Tom", "Todd", "Neef", "Jeff"]


def making_matches(girls: list, boys: list):
    result = list()
    
    for girl_and_boy in itertools.zip_longest(girls, boys):
        if girl_and_boy[0]:
            result.append(girl_and_boy[0])
        if girl_and_boy[1]:
            result.append(girl_and_boy[1])
    
    return result


if __name__ == '__main__':
    print(making_matches(girls, boys))
