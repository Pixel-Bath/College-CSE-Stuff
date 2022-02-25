# Author: Kevin
# Email: ******
# Section: D
# Date: 2-25-2022

'''
This code calculates the change when given a price and an
amount paid.
'''

# input the variables
print("Change Calculator")

price = round(100 * float(input("Enter the price of the item bought: ")))

pay = round(100 * float(input("Enter the amount of money you gave the cashier: ")))

change = pay - price

# Calculate the change by sorting remainders and doing floor division.
# A new variable for each remainder is implemented to tell the system
# how much is left to calculate with.

dollar = change // 100
dollarPartial = change % 100

quarter = dollarPartial // 25
quarterPartial = dollarPartial % 25

dime = quarterPartial // 10 
dimePartial = quarterPartial % 10

nickel = dimePartial // 5
nickelPartial = dimePartial % 5

penny = nickelPartial // 1

# Print the answers

print(" ")
print("Your change: ", change / 100)
print(" ")

print("dollars: ", dollar)
print("quarters: ", quarter)
print("dimes: ", dime)
print("nickels: ", nickel)
print("pennies: ", penny)
