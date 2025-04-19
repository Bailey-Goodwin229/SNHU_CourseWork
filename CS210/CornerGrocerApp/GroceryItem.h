/*
Bailey Goodwin
4/18/2025
CS210
This is the header file defining the information for the assessors, mutators, and functions
*/

#pragma once
#include <string>
#include <map>
using namespace std;
#ifndef GROCERYITEM_H
#define GROCERYITEM_H


//creates a class for the retrieval of an item
class GroceryItem
{
//Declares public information for all to use
public:

	//declare functions
	void readInputFile();
	void writeOutputFile();
	void inputItem(string name);
	void fullList();
	void printHistogram();
	void mainMenu();

//declare private variable
private:

	map<string, int> itemFrequency;
};

#endif
