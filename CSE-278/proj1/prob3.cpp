/**
 * This program evaluates the security of
 * a password by length, number amount,
 * and special character amount.
 * 
 * Fix: Style errors and comments.
*/
// Copyright by Kevin, 2/22/2023

#include <iostream>

int main() {
    std::string key = "";

    // Initialize boolean values:
    bool tooShort = false;
    bool missingLetter = true;
    bool missingNum = true;
    bool missingSpecial = true;

    // Input password:
    std::cin >> key;

    // Check if password is too short:
    if (key.length() < 8) {
        std::cout << "Too short" << std::endl;
        tooShort = true;
    }

    // Loop through password letter by letter:
    for (uint16_t i = 0; i < key.length(); i++) {
        // Check for a digit:
        if (isdigit(key.at(i))) {
            missingNum = false;
        }

        // Check for a letter:
        if (isalpha(key.at(i))) {
            missingLetter = false;
        }

        // Check for a special character:
        if (!isalpha(key.at(i)) && !isdigit(key.at(i))) {
            missingSpecial = false;
        }
    }

    // Print only if there are no letters:
    if (missingLetter) {
        std::cout << "Missing letter" << std::endl;
    }

    // Print only if there are no numbers:
    if (missingNum) {
        std::cout << "Missing number" << std::endl;
    }

    // Print only if there are no special characters:
    if (missingSpecial) {
        std::cout << "Missing special" << std::endl;
    }

    // If all boolean values are false, password is OK:
    if (!tooShort && !missingNum && !missingSpecial) {
        std::cout << "OK" << std::endl;
    }
}
