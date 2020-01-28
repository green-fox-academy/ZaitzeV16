# Add "My todo:" to the beginning of the todoText
# Add " - Download games" to the end of the todoText
# Add " - Diablo" to the end of the todoText but with indention

# Expected outpt:

# My todo:
#  - Buy milk
#  - Download games
#      - Diablo

todoText = " - Buy milk\n"

print(todoText)

todoText = "My todos:" + "\n"\
           + todoText[:] \
           + " - Download games" + "\n"\
           + " - Diablo"
print(todoText)
