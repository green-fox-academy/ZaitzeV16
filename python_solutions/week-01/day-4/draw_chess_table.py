# Crate a program that draws a chess table like this
#
# % % % %
#  % % % %
# % % % %
#  % % % %
# % % % %
#  % % % %
# % % % %
#  % % % %

for i in range(8):
    if i % 2 == 0:
        message = "{1}{0}{1}{0}{1}{0}{1}{0}"
    else:
        message = "{0}{1}{0}{1}{0}{1}{0}{1}"

    print(message.format(" ", "%"))

