/*
Bailey Goodwin
04/18/2025
CS210
This is the main program for the Corner Grocer App
*/
#include <iostream>
#include <fstream>
#include <string>
#include <map>
#include <limits>
#include "GroceryItem.h"
using namespace std;

//Declare GroceryItem Class
GroceryItem cornerGrocer;

//main function
int main()
{   
	//calls fucntions for reading input file and saving it to output
	cornerGrocer.readInputFile();
	cornerGrocer.writeOutputFile();

	//declares variable for menu input
	int userInput = 0;

	//uses while loop to continue the program until the user exits
	while (userInput != 4) {

		//displays main menu
		cornerGrocer.mainMenu();

		//takes user input		
		cout << "Select an option 1-4: ";
		cin >> userInput;

		//use if/else loops to get parameter for each options
		//option 1 uses search item function
		if (userInput == 1) {
			
			//sets up being able to take input
			string name;
			cout << "Enter the item you're looking for: " << endl;
			cin >> name;

			//calls function that allows search for name
			cornerGrocer.inputItem(name);
		}

		//option 2 prints the full list
		else if (userInput == 2) {
			cornerGrocer.fullList();
		}

		//option 3 prints histogram of frequencies
		else if (userInput == 3) {
			cornerGrocer.printHistogram();
		}
		
		else if (userInput == 4) {
			cout << "Thank you for using the Corner Grocer App, have a good rest of your day!" << endl;
			break;
		}
		
		//sets validation for string or char input
		else if (cin.fail()) {
			cout << "Invalid input, please enter a number 1-4. " << endl;
			cin.clear();
			cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
		}
		
		//sets input validation if input isn't one of the options for int
		else {
			cout << "Invalid input, please try again." << endl;
			continue;
		}
	}
}

