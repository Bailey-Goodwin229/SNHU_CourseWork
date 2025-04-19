/*
Bailey Goodwin
CS 210
04/05/2025
Header file that declares variables and function names
*/

#pragma once
#ifndef BANKINGAPP_H
#define BANKINGAPP_H

//Creates class for the banking app
class BankingInfo {

//Declaring public assessors, mutators, and functions
public:
	void SetInitialInvestment(double& t_initialInvestment);
	void SetMonthlyDeposits(double& t_monthlyDeposits);
	void SetInterestRate(double& t_annualInterestRate);
	void SetNumYears(int& t_numYears);
	double GetInitialInvestment() const;
	double GetMonthlyDeposits() const;
	double GetInterestRate() const;
	int GetNumYears() const;
	double balanceWithoutMonthlyDeposits(double t_initialInvestment, double t_annualInterestRate, int t_numYears);
	double balanceWithMonthlyDeposts(double t_initialInvestment, double t_monthlyDeposits, double t_annualInterestRate, int t_numYears);

	//Declaring private variables
private:
	double m_totalAmount;
	double m_interestAmount;
	double m_yearlyTotalInterest;
	double m_monthlyDeposits;
	double m_numOfYears;
};

#endif