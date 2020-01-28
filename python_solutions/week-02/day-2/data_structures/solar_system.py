# Saturn is missing from the planet_list
# Insert it into the correct position

planet_list = ["Mercury", "Venus", "Earth", "Mars", "Jupiter", "Uranus",
               "Neptune"]


# Expected output: "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn",
# "Uranus", "Neptune"


def put_saturn(planet_list: list):
    planet_list.insert(planet_list.index("Uranus"), "Saturn")
    return planet_list


if __name__ == '__main__':
    print(put_saturn(planet_list))
