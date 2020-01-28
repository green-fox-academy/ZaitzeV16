n = -1

while n < 0:
    try:
        n = int(input("Give me a number would ya': "))
        break
    except ValueError:
        continue

msg = "{} is{} an Armstrong number"
nope = " not"
nums = list(str(n))
if sum(map(lambda x: pow(int(x), len(nums)), nums)) == n:
    nope = ""

print(msg.format(n, nope))
