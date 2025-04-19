/*
This is the main function that runs the clock and header files along with the main clock program
Bailey Goodwin
03/23/2025
*/


#include <iostream>
#include <string>
#include "Header.h"
using namespace std;

//creates function that allows the menu to work with each option
unsigned int MenuChoice(unsigned int maxChoice) {
	bool done = false;
	unsigned int choice;
	while (!done) {
		cout << "Pick and option 1 - 4: ";
		cin >> choice;
		if (choice >= 1 && choice <= maxChoice)
			done = true;
		else
			cout << "Invalid choice, try another.";
	}
	return choice; 
}

//Function that shows the menu after an input and asks for user to pick options
void printMenu() {
	cout << "********************" << endl; 
	cout << "* " << "- 1. Add Hour" << "    *" << endl;
	cout << "* " << "- 2. Add Minute" << "  *" << endl;
	cout << "* " << "- 3. Add Second" << "  *" << endl;
	cout << "* " << "- 4. Exit" << "        *" << endl;
	cout << "********************" << endl;
}

//Function that displays the clock time in 12-hour and 24-hour format
void printClocks(unsigned int h, unsigned int m, unsigned int s) {
	cout << "*************************     *************************" << endl;
	cout << "*     12-Hour Clock     *     *      24-Hour Clock    *" << endl;
	cout << endl;
	cout << "*     " << See12HourClock(h, m, s) << "       *" << "     *      " << See24HourClock(h, m, s) << "         *" << endl;
	cout << endl;
	cout << "*************************     *************************" << endl;
}

//Main program that runs all of the functions
int main() {
	//welcome statement
	cout << "Welcome to the Chada Clock!" << endl;
	cout << "This shows the time in the 12-hour and 24 hour clocks." << endl;
	cout << "Please input the time as directed." << endl;

	//Sets the starting time
	cout << "Initial hour: ";
	cin >> clockHour;
	cout << "Initial minute: ";
	cin >> clockMinute;
	cout << "Initial second: ";
	cin >> clockSecond;

	printClocks(clockHour, clockMinute, clockSecond);

	bool done = false;
	while (!done) {
		printMenu(); //Print menu function

		unsigned int choice = MenuChoice(4); //connects menu choices with the functions that apply to them
		if (choice == 1) {
			AddHour();  // Connects to AddHour function
		}
		else if (choice == 2) {
			AddMinute(); // Connects to AddMinute fucntion
		}
		else if (choice == 3) {
			AddSecond(); // Connects to AddSecond function
		}
		else if (choice == 4) {
			done = true; // Exits program
			break;
		}
		else
			(void)0; 
		//Displays updated clock time based on command
		printClocks(clockHour, clockMinute, clockSecond);
	}

	cout << "Good bye!" << endl;

	return 0;
}
