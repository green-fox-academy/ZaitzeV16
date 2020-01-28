students = [
    {'name': 'Theodor', 'age': 3, 'candies': 2},
    {'name': 'Paul', 'age': 9.5, 'candies': 2},
    {'name': 'Mark', 'age': 12, 'candies': 5},
    {'name': 'Peter', 'age': 7, 'candies': 3},
    {'name': 'Olaf', 'age': 12, 'candies': 7},
    {'name': 'George', 'age': 10, 'candies': 1}
]


# create a function that takes a list of students and prints:
# - how many candies are owned by students altogether

def candy_counter(students: list):
    return sum(student.get("candies") for student in students)


# create a function that takes a list of students and prints:
# - The sum of the age of people who have less than 5 candies

def age_sum(students: list):
    students = filter(lambda student: student.get("candies") < 5, students)
    return sum(student.get("age") for student in students)


if __name__ == '__main__':
    print(candy_counter(students))
    print(age_sum(students))
