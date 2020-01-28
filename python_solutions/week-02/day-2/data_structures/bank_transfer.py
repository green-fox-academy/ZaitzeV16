accounts = [
    {'client_name': 'Igor',
     'account_number': 11234543,
     'balance': 203004099.2},
    {'client_name': 'Vladimir',
     'account_number': 43546731,
     'balance': 5204100071.23},
    {'client_name': 'Sergei',
     'account_number': 23456311,
     'balance': 1353600.0}
]


# Create function that returns the name and balance of cash on an account in
# a list
def get_name_and_balance(accounts: list, account_number: int):
    for account in accounts:
        if account.get("account_number") == account_number:
            return account.get("client_name"), account.get("balance")
    else:
        print("404 - account not found")


# Create function that transfers an amount of cash from one account to another
# it should have three parameters:
#
#  - from account_number
#  - to account_number
#  - amount to transfer
#
# Print "404 - account not found" if any of the account numbers don't exist

def transfer_amount(account_number_from: int, account_number_to: int, amount):
    global accounts
    target_accounts = [get_name_and_balance(accounts, account_number_from),
                       get_name_and_balance(accounts, account_number_to)]
    
    if not target_accounts[:][:]:
        print("404 - account not found")
        return
    
    for account in accounts:
        if account.get("account_number") == account_number_from:
            account["balance"] -= amount
        elif account.get("account_number") == account_number_to:
            account["balance"] += amount


if __name__ == '__main__':
    print(get_name_and_balance(accounts, 11234543))
    # The output should be: "Igor", "203004099.2"
    
    transfer_amount(43546731, 23456311, 500.0)
    print(accounts)
    # After printing the "accounts" it should look like:
    # accounts = [
    #	{ 'client_name': 'Igor', 'account_number': 11234543, 'balance':
    #	203004099.2 },
    #	{ 'client_name': 'Vladimir', 'account_number': 43546731, 'balance':
    #	5204099571.23 },
    #	{ 'client_name': 'Sergei', 'account_number': 23456311, 'balance':
    #	1354100.0 }
    # ]
