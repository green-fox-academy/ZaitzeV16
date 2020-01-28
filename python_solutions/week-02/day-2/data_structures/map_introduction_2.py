# # Map introduction 2
#
# - Create a map where the keys are strings and the values are strings with the
#   following initial values
#
#   | Key               | Value                   |
#   | :---------------- | :---------------------- |
#   | 978-1-60309-452-8 | A Letter to Jo          |
#   | 978-1-60309-459-7 | Lupus                   |
#   | 978-1-60309-444-3 | Red Panda and Moon Bear |
#   | 978-1-60309-461-0 | The Lab                 |
#
isbn_codes = {
    "978-1-60309-452-8": "A Letter to Jo",
    "978-1-60309-459-7": "Lupus",
    "978-1-60309-444-3": "Red Panda and Moon Bear",
    "978-1-60309-461-0": "The Lab",
}

# - Print all the key-value pairs in the following format
#   ```text
#   A Letter to Jo (ISBN: 978-1-60309-452-8)
#   Lupus (ISBN: 978-1-60309-459-7)
#   Red Panda and Moon Bear (ISBN: 978-1-60309-444-3)
#   The Lab (ISBN: 978-1-60309-461-0)
#   ```
for (k, v) in isbn_codes.items():
    print("{} (ISBN: {})".format(v, k))

# - Remove the key-value pair with key 978-1-60309-444-3
isbn_codes.pop("978-1-60309-444-3")

# - Remove the key-value pair with value The Lab
for (k, v) in isbn_codes.items():
    if v is "The Lab":
        isbn_codes.pop(k)
        break

# - Add the following key-value pairs to the map
#
#   | Key               | Value                 |
#   | :---------------- | :-------------------- |
#   | 978-1-60309-450-4 | They Called Us Enemy  |
#   | 978-1-60309-453-5 | Why Did We Trust Him? |
#
isbn_codes["978-1-60309-450-4"] = "They Called Us Enemy"
isbn_codes["978-1-60309-453-5"] = "Why Did We Trust Him"

# - Print whether there is an associated value with key 478-0-61159-424-8 or
# not
print(isbn_codes.get("478-0-61159-424-8"))

# - Print the value associated with key 978-1-60309-453-5
print(isbn_codes.get("978-1-60309-453-5"))
