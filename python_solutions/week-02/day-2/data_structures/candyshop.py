shop_items = ["Cupcake", 2, "Brownie", False]

# Accidentally we added "2" and "false" to the list.
# Your task is to change from "2" to "Croissant" and change from "false" to
# "Ice cream"
# No, don't just remove the items :)
# Create a function called sweets() which takes the list as a parameter.
# Expected output: "Cupcake", "Croissant", "Brownie", "Ice cream"


def sweets(shop_items: list):
    shop_items[shop_items.index(2)] = "Croissant"
    shop_items[shop_items.index(False)] = "Ice cream"
    
    return shop_items


if __name__ == '__main__':
    print(sweets(shop_items))
