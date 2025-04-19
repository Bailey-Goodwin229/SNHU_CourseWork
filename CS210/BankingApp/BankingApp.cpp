/* Bailey Goodwin/ CS 210/ 04-05-2025/ Program that defines banking class with assessors, mutators, and some functions*/

#include <iostream>
#include <iomanip>
#include "BankingApp.h"
using namespace std;

//Defines the Banking Class

//Assessors and mutators for the Banking Class
void BankingInfo::SetInitialInvestment(double& t_initialInvestment) {
	m_totalAmount = t_initialInvestment;
}

void BankingInfo::SetMonthlyDeposits(double& t_monthlyDeposits) {
	m_monthlyDeposits = t_monthlyDeposits;
}

void BankingInfo::SetInterestRate(double& t_annualInterest) {
	m_yearlyTotalInterest = t_annualInterest;
}

void BankingInfo::SetNumYears(int& t_numYears) {
	m_numOfYears = t_numYears;
}

double BankingInfo::GetInitialInvestment() const {
	return m_totalAmount;
}

double BankingInfo::GetInterestRate() const {
	return m_yearlyTotalInterest;
}

double BankingInfo::GetMonthlyDeposits() const {
	return m_monthlyDeposits;
}

int BankingInfo::GetNumYears() const {
	return m_numOfYears;
}

//Defines function for displaying and calculating balance without monthly deposits
double BankingInfo::balanceWithoutMonthlyDeposits(double t_initialInvestment, double t_annualInterestRate, int t_numYears) {
	m_totalAmount = t_initialInvestment;

	//Display the head of the table
	cout << endl << "	Balance and Interest Without Additional Monthly Deposits	" << endl;
	cout << string(70, '=') << endl;
	cout << "Year		Year End Balance	Year End Earned Interest" << endl;
	cout << string(70, '-') << endl;

	//Displays year, year end interest, and year end balance
	//calculates year end interest and year end balance
	for (int i = 0; i < t_numYears; i++) {
		m_interestAmount = m_totalAmount * (t_annualInterestRate / 100);
		m_totalAmount = m_totalAmount + m_interestAmount;
		cout << " " << setw(5) << (i + 1) << "		$" << fixed << setprecision(2) << m_totalAmount << "				$";
		cout << m_interestAmount << endl;
	}
	return m_totalAmount;
}

//Defines fucntion for displaying and calculating balance with monthly deposits
double BankingInfo::balanceWithMonthlyDeposts(double t_initialInvestment, double t_monthlyDeposits, double t_annualInterestRate, int t_numYears) {
	m_totalAmount = t_initialInvestment;

	//Display the head of the table
	cout << endl << "	Balance and Interest With Additional Monthly Deposits	" << endl;
	cout << string(70, '=') << endl;
	cout << "Year		Year End Balance	Year End Earned Interest" << endl;
	cout << string(70, '-') << endl;

	//Displays year, year end interest, and year end balance
	//calculates year end interest and year end balance
	for (int i = 0; i < t_numYears; i++) {
		m_yearlyTotalInterest = 0;

		for (int j = 0; j < 12; j++) {
			m_interestAmount = (m_totalAmount + t_monthlyDeposits) * ((t_annualInterestRate / 100.00) / 12.00);
			m_yearlyTotalInterest = m_yearlyTotalInterest + m_interestAmount;
			m_totalAmount = m_totalAmount + t_monthlyDeposits + m_interestAmount;
		}
		cout << " " << setw(5) << (i + 1) << "		$" << fixed << setprecision(2) << m_totalAmount << "				$";
		cout << m_yearlyTotalInterest << endl;
	}
	return m_totalAmount;
}