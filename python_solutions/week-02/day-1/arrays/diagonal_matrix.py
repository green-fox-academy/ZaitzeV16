# - Create (dynamically) a two dimensional array
#   with the following matrix. Use a loop!
#
#   1 0 0 0
#   0 1 0 0
#   0 0 1 0
#   0 0 0 1
#
# - Print this two dimensional array to the output

diagonal_matrix = list()

for i in range(4):
    current_line = list()
    
    for j in range(4):
        current_line.append(1 if i == j else 0)
    else:
        diagonal_matrix.append(current_line)

for line in diagonal_matrix:
    print(line)
