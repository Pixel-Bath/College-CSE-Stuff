// Copyright 2023
// Purpose: This program provides functions for the menu options in main file.

#include <fstream>
#include <iostream>
#include <vector>
#include <string>
#include "hw2/functions.h"

/**
 * Method loads files from filestream and saves as vector.
 * @param s the name of file
 * @return vector with all file data.
*/
std::vector<std::string> loadFile(std::string s) {
  // Create file stream:
  std::ifstream inFS;
  inFS.open(s);

  // Load files and store the info in a vector:
  std::vector<std::string> v;

  // Return if the file cannot be opened:
  if (!inFS.is_open()) {
    return v;
  }

  // Add words to vector:
  std::string word = "";
  while (!inFS.eof()) {
    inFS >> word;
    v.push_back(word);
  }

  // Close stream and return vector:
  inFS.close();
  return v;
}  // end loadFile method.

/**
 * Method prints all crew names.
 * @param x the file content containing crew names.
*/
void crewNames(std::vector<std::string> x) {
  std::cout << "--- Crew Names ---" << std::endl;
  for (uint16_t i = 0; i < x.size(); i++) {
    // Every other string in the vector is a crew name.
    if (i % 2 == 0) {
      std::cout << x.at(i) << std::endl;
    }
  }
}  // end crewNames method.

/**
 * Helper method to sort flight location names alphabetically.
 * @param x the file content containing unique flight locations.
 * @return the sorted vector.
*/
std::vector<std::string> sortFlightNames(std::vector<std::string> x) {
  // use Selection Sort:
  int ind = 0;
  for (uint16_t i = 0; i < x.size(); i++) {
    ind = i;
    for (uint16_t j = i; j <= x.size() - 1; j++) {
      if (x.at(ind) > x.at(j)) {
        ind = j;
      }
    }
    std::string temp = x.at(i);
    x.at(i) = x.at(ind);
    x.at(ind) = temp;
  }
  return x;
}  // end sortFlightNames method.

/**
 * Method prints unique flight locations in alphabetical order.
 * @param x the file content containing unique flight locations.
*/
void flightNames(std::vector<std::string> x) {
  std::cout << "--- Flight Locations ---" << std::endl;
  std::vector<std::string> y;
  y.push_back(x.at(0));
  bool isDupe = false;

  // Add only unique values to y:
  for (uint16_t i = 0; i < x.size(); i++) {
    for (uint16_t j = 0; j < y.size(); j++) {
      if (x.at(i) == y.at(j)) {
        isDupe = true;
      }
    }

    if (!isDupe) {
      y.push_back(x.at(i));
    } else {
      isDupe = false;
    }
  }  // end flightNames method

    // Sort y:
  y = sortFlightNames(y);

    // Print y:
  for (uint16_t k = 0; k < y.size(); k++) {
    std::cout << y.at(k) << std::endl;
  }
}  // end flightNames method.

/**
 * Method prints crews given departure and arrival flight locations.
 * @param x vector listing crew info.
 * @param y vector listing flight info.
*/
void crewsForFlight(std::vector<std::string> x, std::vector<std::string> y) {
  // Print locations:
  flightNames(y);

  // Initialize vars:
  bool flight = false;
  int ind;
  std::string from = "";
  std::string to = "";

  // Prompt user until a flight is found:
  while (!flight) {
    std::cout << "\nFROM >> ";
    std::cin >> from;
    std::cout << "TO >> ";
    std::cin >> to;

    // Capitalize all letters in location names:
    for (int i = 0; i < 3; i++) {
      to[i] = toupper(to[i]);
      from[i] = toupper(from[i]);
    }

    // Get an index value for the sequences in crewInfo vector:
    ind = 0;

    // Iterate every two elements to match flights in other file:
    for (uint16_t i = 0; i < (y.size() - 1); i+= 2) {
      // Break out of loop if the queries match the indices:
      if (from == y.at(i) && to == y.at(i + 1)) {
        flight = true;
        break;
      }
      ind++;
    }

    // Prompt user again if no flight was found:
    if (!flight) {
      std::cout << "No flight was found!! Please try again..." << std::endl;
    }
  }

  // Print the crew list:
  std::cout << "---- Crew List ----" << std::endl;
  int count = 0;
  for (uint16_t i = 0; i < x.size(); i++) {
    if (i % 2 != 0) {
      std::string sequence = x.at(i);
      if (sequence[ind] == '1') {
        std::cout << x.at(i - 1) << std::endl;
        count++;
      }
    }
  }
  std::cout << count << " crew(s) work(s) on the flight ";
  std::cout << from << "-" << to << std::endl;
}  // end flightsForCrew method.

/**
 * Method returns the flight route for a specified
 * crew member.
 * @param x vector listing crew info.
 * @param y vector listing flight info.
*/
void flightsForCrew(std::vector <std::string> x, std::vector<std::string> y) {
  std::string crewName;
  bool record = false;
  std::string sequence = "";

  // Prompt a name until a crew member is named:
  while (!record) {
    std::cout << "Enter the crew name >> ";
    std::cin >> crewName;

    // convert to uppercase:
    for (uint16_t i = 0; i < crewName.length(); i++) {
      crewName[i] = toupper(crewName[i]);
    }

    // find the bit sequence associated with the crew member:
    for (uint16_t i = 0; i < x.size(); i += 2) {
      if (crewName == x.at(i)) {
        sequence = x.at(i + 1);
        record = true;
        break;
      }
    }

    if (!record) {
      std::cout << "No record for " << crewName;
      std::cout << ". Please try again..." << std::endl;
    }
  }

  std::cout << "---- Assigned Flights ----" << std::endl;

  // Create a vector of flights associated with the crew member:
  std::vector<std::string> assignments;
  bool feasible = true;

  // Add all assigned flights to vector:
  for (uint16_t i = 0; i < sequence.length(); i++) {
    if (sequence[i] == '1') {
      std::cout << y.at(i * 2) << "-" << y.at((i * 2) + 1) << std::endl;

      assignments.push_back(y.at(i * 2));
      assignments.push_back(y.at((i * 2) + 1));
    }
  }

  // If the vector is empty, no flights were assigned:
  if (assignments.size() == 0) {
    std::cout << "No flight was assigned to " << crewName;
    std::cout << " !!!" << std::endl;

  } else {
    for (uint16_t i = 1; i < (assignments.size() - 2); i += 2) {
      // If the departure is different from the previous arrival location:
      if (assignments.at(i) != assignments.at(i + 1)) {
        feasible = false;
      }
    }

    // Print according to feasibility of the crew member's schedule:
    if (feasible) {
      std::cout << "The flight sequence is feasible" << std::endl;
    } else {
      std::cout << "The flight sequence is not feasible!!" << std::endl;
    }
  }
}  // end crewsForFlight method.
