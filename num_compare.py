# Author: Kevin Koepp
# Date: 3-4-2022
# CSE 102 Section D
'''
This program compares two input numbers and outputs whether the first
number is greater than, less than, or equal to the second number.
'''

firstNum = int(input("Enter the first number: "))
secondNum = int(input("Enter the second number: "))

if firstNum > secondNum:
    print("The number ", firstNum, " is greater than ", secondNum)
elif firstNum < secondNum:
    print("The number ", firstNum, " is less than ", secondNum)
elif firstNum == secondNum:
    print("The number ", firstNum, " is equal to ", secondNum)
    
