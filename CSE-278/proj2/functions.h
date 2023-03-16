// Copyright 2023

#ifndef FUNCTIONS_H
#define FUNCTIONS_H

#include <vector>
#include <string>

std::vector<std::string> loadFile(std::string s);
void crewNames(std::vector<std::string> x);
void flightNames(std::vector<std::string> x);
void crewsForFlight(std::vector<std::string> x, std::vector<std::string> y);
void flightsForCrew(std::vector<std::string> x, std::vector<std::string> y);
#endif  // FUNCTIONS_H
