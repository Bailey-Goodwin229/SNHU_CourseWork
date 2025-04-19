/*
Bailey Goodwin
CS210
This is the main application for the banking app which will run the main program
04/05/2025
*/

#include <iostream>
#include <iomanip>
#include <string>
#include <limits>
#include <cctype>
#include <stdexcept>
#include "BankingApp.h"
using namespace std;

BankingInfo myInformation;

//Function for starting screen
void StartScreen() {
	//declares variables
	double initialInvestment;
	double monthlyDeposits;
	double annualInterest;
	int years;

	//sets up try/catch statement
	try {
		cout << string(40, '*') << endl;
		cout << string(14, '*') << " Data Input " << string(14, '*') << endl;
		
		//validates and sets value for intial investment
		cout << "Initial Investment Amount: $";
		cin >> initialInvestment;
		if (initialInvestment < 0) {
			throw runtime_error("Please enter positive number.");
		}
		if (cin.fail()) {
			cin.clear();
			cout << "Enter a number." << endl;
		}
		
		myInformation.SetInitialInvestment(initialInvestment);

		//validates and sets value for monthly deposits
		cout << "Monthly Deposit Amount: $";
		cin >> monthlyDeposits;
		if (cin.fail()) {
			cout << endl;
			cin.clear();
			cout << "Enter a number." << endl;
		}
		if (monthlyDeposits < 0) {
			throw runtime_error("Please enter positive number.");
		}
		myInformation.SetMonthlyDeposits(monthlyDeposits);

		//validates and sets value for interest rate
		cout << "Annual Interest: %";
		cin >> annualInterest;
		if (cin.fail()) {
			cout << endl;
			cin.clear();
			cout << "Enter a number." << endl;
		}
		if (annualInterest < 0) {
			throw runtime_error("Please enter positive number.");
		}
		myInformation.SetInterestRate(annualInterest);

		//validates and sets value for number of years
		cout << "Number of Years: ";
		cin >> years;
		if (cin.fail()) {
			cout << endl;
			cin.clear();
			cout << "Enter a number." << endl;
		}
		if (years < 0) {
			throw runtime_error("Please enter positive number.");
		}
		myInformation.SetNumYears(years);

		system("PAUSE");
	}
	catch (runtime_error& excpt) {
		cout << excpt.what() << endl;
		system("PAUSE");
		system("cls");
		StartScreen();
	}
}


//Main function
int main() {
	char userInput = 'a';
	
	//Set up while loop to run program
	while (userInput != 'n') {
		system("cls");
		StartScreen();

		myInformation.balanceWithoutMonthlyDeposits(myInformation.GetInitialInvestment(), myInformation.GetInterestRate(), myInformation.GetNumYears());
		myInformation.balanceWithMonthlyDeposts(myInformation.GetInitialInvestment(), myInformation.GetMonthlyDeposits(), myInformation.GetInterestRate(), myInformation.GetNumYears());
		
		cout << "Enter 'n' to quit the program. Enter any other character or number to use it again." << endl;
		cin >> userInput;
	}
	
	cout << "Thank you and Goodbye!" << endl;
	return 0;
}

