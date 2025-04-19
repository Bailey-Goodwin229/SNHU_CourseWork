/*
Bailey Goodwin
04/18/2025
CS210
This is a file that sets the parameters for the items set in the 'h' file
*/


#include "GroceryItem.h"
#include <string>
#include <iostream>
#include <map>
#include <fstream>
using namespace std;

//defines readInputFile method
void GroceryItem::readInputFile() {
	//opens input file
	ifstream inputFile("CS210_Project_Three_Input_File.txt");
	
	//prints message whether file is opened or not
	if (!inputFile.is_open()) {
		cout << "Error opening input file." << endl;
	}
	else {
		cout << "Input file successfully opened." << endl;
	}

	//declares name variable
	string name;

	//creates while loop to put item in a new map called itemFrequency with the frequency the item appears
	while (inputFile >> name) {
		itemFrequency[name]++;
	}

	//close input file after it's done reading through the information
	inputFile.close();
}

//defines writeOutputFile method and saves to "frequency.dat"
void GroceryItem::writeOutputFile() {
	//creates output file and prepares for writing
	ofstream outputFile("frequency.dat");

	//checks to see if file is opened or created properly, creates message based on outcoem
	if (!outputFile.is_open()) {
		cout << "Error opening or creating output file." << endl;
	}
	else {
		cout << "Output file successfully created." << endl;
	}

	//write for function that takes information from itemFrequency map and stores onto new output file
	for (const auto& name : itemFrequency) {
		outputFile << name.first << " " << name.second << endl;
	}

	//close output file and display successful save
	outputFile.close();
	cout << "Back-up save successful!" << endl;
}

void GroceryItem::inputItem(string name) {
	//fixes case sensitive input
	name[0] = toupper(name[0]);

	//if/else statement to output item or to validate input
	if (itemFrequency.count(name)) {
		cout << "Frequency of " << name << " is " << itemFrequency[name] << endl;
	}
	else {
		cout << name << " not found." << endl;
	}
}

//outputs full list of items with frequency
void GroceryItem::fullList() {
	cout << "Item Frequency List:" << endl;
	//uses for loop to print each item and frequency of item
	for (auto name : itemFrequency) {
		cout << name.first << " " << name.second << endl;
	}
}

//creates histogram for item
void GroceryItem::printHistogram() {
	cout << "Histogram of Item Frequency:" << endl;

	//for loop to go through items and nested for loop to print stars
	for (auto name : itemFrequency) {
		cout << name.first << " ";
		for (int i = 0; i < name.second; i++) {
			cout << "*";
		}
		cout << endl;
	}
}

//function that creates display 
void GroceryItem::mainMenu() {
		
		//sets parameter for menu screen
	cout << "*****************************************" << endl;
	cout << "*       Corner Grocer Application       *" << endl;
	cout << "*****************************************" << endl;
	cout << "*                                       *" << endl;
	cout << "*   1. Input an item to search for      *" << endl;
	cout << "*   2. Show full item frequency list    *" << endl;
	cout << "*   3. Show item frequency histogram    *" << endl;
	cout << "*   4. Exit                             *" << endl;
	cout << "*                                       *" << endl;
	cout << "*****************************************" << endl;
	cout << endl;
}