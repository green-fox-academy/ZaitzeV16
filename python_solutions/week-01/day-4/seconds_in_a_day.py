"""
Write a program that prints the remaining seconds (as an integer) from a
day if the current time is represented by the variables
"""

current_hours = 14
current_minutes = 34
current_seconds = 42

whole_day = 24 * 60 * 60
current_time = (current_hours * 60 + current_minutes) * 60 + current_seconds

print("remaining: {}".format(whole_day - current_time))
