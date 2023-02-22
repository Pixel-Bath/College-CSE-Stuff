/**
 * This program takes an unsigned integer and returns
 * whether it is a power of two or not.
 * 
 * Fix: Added documents (inline comments) and fixed style errors.
*/
// Copyright by Kevin, 2/22/2023


#include <iostream>

int main() {
     unsigned int num;
     unsigned int powerNum;

     // take input:
     std::cout << "Enter an unsigned integer number:" << std::endl;
     std::cin >> num;

     // a power of two will equal 0 if
     // that number "&" the number before it equals 0:
     powerNum = num & (num - 1);

     // Check if powerNum is 0 or if the input was less than 2:
     if (powerNum == 0 && num >= 2) {
          std::cout << num << " is a power of two." << std::endl;
     } else {
          std::cout << num << " is NOT a power of two." << std::endl;
     }

     return 0;
}
