/**
 * This program calculates income tax owed
 * given wages, taxable interest, unemployment
 * compensation, status, and taxes withheld.
 * 
 * Fix: Added style fixes and comments.
*/
// Copyright by Kevin Koepp, 2/22/2023

#include <iostream>
#include <cmath>

int main() {
    int wages;
    int interest;
    int unemp;
    int status;
    int withheld;

    // Take inputs:
    std::cin >> wages;
    std::cin >> interest;
    std::cin >> unemp;
    std::cin >> status;
    std::cin >> withheld;

    // Calculate AGI:
    int agi = wages + interest + unemp;
    std::cout << "AGI: $" << agi << std::endl;

    // Cut off program if AGI is too high:
    if (agi > 120000) {
        std::cout << "Error: Income too high to use this form" << std::endl;
    } else {
      
        // Calculate deduction using status:
        int deduction;
        switch (status) {
            case 2:
                deduction = 24000;
                break;
            default:
                status = 1;
                deduction = 12000;
                break;
        }

        // Subtract agi from deduction to calculate income:
        int income = agi - deduction;

        // income cannot be less than 0:
        if (income < 0) {
            income = 0;
        }

        std::cout << "Deduction: $" << deduction << std::endl;
        std::cout << "Taxable income: $" << income << std::endl;

        double federal;

        // Calculate federal tax using income amt:
        if (status == 1) {
            if (income < 10001) {
                federal = round(income / 10);
            } else if (10001 <= income && income <= 40000) {
                federal = round(0.12 * (income - 10000)) + 1000;
            } else if (40001 <= income && income <= 85000) {
                federal = round(0.22 * (income - 40000)) + 4600;
            } else {
                federal = round(0.24 * (income - 85000)) + 14500;
            }
        } else {
            if (income < 20001) {
                federal = round(income / 10);
            } else if (20001 <= income && income <= 80000) {
                federal = round(0.12 * (income - 20000)) + 2000;
            } else {
                federal = round(0.22 * (income - 80000)) + 9200;
            }
        }

        std::cout << "Federal tax: $" << federal << std::endl;

        // Calculate taxes due:
        int due = federal - withheld;

        // Taxes are refunded if the number is negative:
        if (due < 0) {
            std::cout << "Tax refund: $" << abs(due) << std::endl;
        } else {
            std::cout << "Taxes Owed: $" << due << std::endl;
        }
    }
}
