// Copyright 2023
// Purpose: This program implements a query app for flight and crew scheduling.
// Date 3/7/2023

#include <iostream>
#include <fstream>
#include <vector>
#include "hw2/functions.h"

int main() {
  // Load files:
  std::vector<std::string> crewInfo = loadFile("CrewSchedule.txt");
  std::vector<std::string> flightInfo = loadFile("Flights.txt");

  // Declare input value:
  int input = 0;

  // If crew or flight vectors are empty, exit the program:
  if (crewInfo.size() == 0 || flightInfo.size() == 0) {
    std::cout << "Could not open the input file(s)!!!" << std::endl;
    input = -1;
  }

  // Loop menu until -1 is input:
  while (input != -1) {
    // Print menu:
    std::cout << "-----------------------------------" << std::endl;
    std::cout << "Airline Crew Scheduling Application" << std::endl;
    std::cout << "-----------------------------------" << std::endl;
    std::cout << " 1 List crew names" << std::endl;
    std::cout << " 2 List all flight locations" << std::endl;
    std::cout << " 3 List crews for the flight" << std::endl;
    std::cout << " 4 List flights for the crew" << std::endl;
    std::cout << "-1 Exit" << std::endl;
    std::cout << "-----------------------------------" << std::endl;
    std::cout << "Enter your choice >> ";

    // Await input:
    std::cin >> input;

    // Menu options:
    if (input == -1) {
      std::cout << "Bye!" << std::endl;
      break;

    } else if (input == 1) {
      crewNames(crewInfo);

    } else if (input == 2) {
      flightNames(flightInfo);

    } else if (input == 3) {
      crewsForFlight(crewInfo, flightInfo);

    } else if (input == 4) {
      flightsForCrew(crewInfo, flightInfo);

    } else {
      std::cout << "The wrong choice!!!" << std::endl;
    }

    // Await enter key:
    std::cout << "\nto continue, press enter...";
    std::cin.get();
    std::cin.ignore();
  }

  return 0;
}  // end main method.
