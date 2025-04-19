/*
Header program for declaring the functions and information for the rest of the program
Bailey Goodwin
03/23/2025
*/

#pragma once
#ifndef HEADER_H
#define HEADER_H
#include <string>
	
//Declares variables for second, minute, and hour of the intial time
extern unsigned int clockSecond;
extern unsigned int clockMinute;
extern unsigned int clockHour;

//Functions for setting the new time and for the options to adjust the current time
void SetTime(unsigned int, unsigned int, unsigned int);
void AddHour();
void AddSecond();
void AddMinute();

//Functions for grabbing what the individual second, minute, or hour is
unsigned int FindSecond();
unsigned int FindMinute();
unsigned int FindHour();

//Functions to Display 24 hour and 12 hour clock
std::string See24HourClock(unsigned int, unsigned int, unsigned int);
std::string See12HourClock(unsigned int, unsigned int, unsigned int);

//Changes digit to string
std::string DigitString(unsigned int);

#endif
