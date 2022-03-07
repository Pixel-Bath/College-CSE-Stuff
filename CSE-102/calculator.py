# Author: Kevin Koepp
# Date: 3-4-2022
# CSE-102 Section D
'''
This program acts as a calculator and allows simple addition, subtraction,
multiplication, and division.
'''

print("Select operation.")
print("     1. Addition")
print("     2. Subtraction")
print("     3. Multiplication")
print("     4. Division")

operation = int(input("Enter your choice: "))

firstNum = int(input("Enter your first number: "))
secondNum = int(input("Enter your second number: "))

if operation == 1:
    numSum = firstNum + secondNum
    print(firstNum, " + ", secondNum, " = ", numSum)
elif operation == 2:
    numDif = firstNum - secondNum
    print(firstNum, " - ", secondNum, " = ", numDif)
elif operation == 3:
    numProd = firstNum * secondNum
    print(firstNum, " * ", secondNum, " = ", numProd)
elif operation == 4:
    if secondNum == 0:
        print("Error: You cannot divide by 0!")
    numQuo = firstNum / secondNum
    print(firstNum, " / ", secondNum, " = ", round(numQuo))
else:
    print("Invalid Operation!")
    
      
      
