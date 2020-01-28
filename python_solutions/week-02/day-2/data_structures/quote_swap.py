# Accidentally I messed up this quote from Richard Feynman.
# Two words are out of place
# Your task is to fix it by swapping the right words with code

# Also, print the sentence to the output with spaces in between.
# Create a function called quote_swap()

# Expected output: "What I cannot create I do not understand."
words = ["What", "I", "do", "create,", "I", "cannot", "not", "understand."]


def quote_swap(words: list):
    words[words.index("cannot")], words[words.index("do")] = \
        words[words.index("do")], words[words.index("cannot")]
    return " ".join(words)


if __name__ == '__main__':
    print(quote_swap(words))
