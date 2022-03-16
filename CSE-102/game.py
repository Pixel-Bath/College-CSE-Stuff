# Author: Kevin
# CSE 102
# 3-14-2022
'''
This program determines the ticket price for watching a game
based on the age.
'''
age = int(input("Enter your age: "))

if (age < 10):
    print("You're not elgible to buy a ticket.")
elif (age > 50 or age < 20):
    print("Ticket price is $12")
else:
    print("Ticket price is $20")
