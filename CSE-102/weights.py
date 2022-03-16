# Author: Kevin
# CSE 102
# 3-14-2022
'''
This program converts an inputted amount of ounces into pounds and
gives the number of ounces left over.
'''

ounces = int(input("How many ounces? "))
pounds = ounces // 16
ounceRemainder = ounces % 16

if ounces < 0:
    print("The number of ounces cannot be negative.")
elif ounces == 0:
    print("There are 0 ounces.")
elif ounces < 16:
    print("There are ", ounces, " ounces.")
else:
    if ounceRemainder == 0:
        print("There are ", pounds, " pounds.")
    else:
        print("There are ", pounds, " pounds and ", ounceRemainder," ounces left over.")
