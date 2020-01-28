students = [
    {'name': 'Mark', 'age': 9.5, 'candies': 2},
    {'name': 'Sean', 'age': 10, 'candies': 1},
    {'name': 'Clark', 'age': 7, 'candies': 3},
    {'name': 'Paul', 'age': 12, 'candies': 5}
]


# create a function that takes a list of students and prints:
# - Who has got more candies than 4 candies

def more_than_4_candies(students: list):
    names = list()
    for student in students:
        if student.get("candies") > 4:
            names.append(student.get("name"))
    
    return names


# create a function that takes a list of students and prints:
#  - how many candies they have on average


def avg_candies(students: list):
    return sum(student.get("candies") for student in students) / len(students)


if __name__ == '__main__':
    print(more_than_4_candies(students))
    print(avg_candies(students))
