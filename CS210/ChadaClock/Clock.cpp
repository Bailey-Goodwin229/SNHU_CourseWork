/*
Program that has the functions for how the clock works
Bailey Goodwin
03/23/2025
*/

#include "Header.h"//Imports header file
using namespace std;

//Assigns the variables for hour, minute and second.
unsigned int clockHour;
unsigned int clockMinute;
unsigned int clockSecond;

//Creates the function that displays time.
void SetTime(unsigned int h, unsigned int m, unsigned int s) {

    clockHour = h;
    clockMinute = m;
    clockSecond = s;
}

//Function that adds the second by 1.
void AddSecond() {

    if ((FindSecond() >= 0) && (FindSecond() <= 58))
        SetTime(FindHour(), FindMinute(), FindSecond() + 1);
    else if (FindSecond() == 59) {
        SetTime(FindHour(), FindMinute(), 0);
        AddMinute();
    }
}

//Function that adds minute by 1.
void AddMinute() {
    if ((FindMinute() >= 0) && (FindMinute() <= 58))
        SetTime(FindHour(), FindMinute() + 1, FindSecond());
    else if (FindMinute() == 59) {
        SetTime(FindHour(), 0, FindSecond());
        AddHour();
    }
    return;
}

//Function that adds hour by 1.
void AddHour() {
    if ((FindHour() >= 0) && (FindHour() <= 22))
        SetTime(FindHour() + 1, FindMinute(), FindSecond());
    else if (FindHour() == 23)
        SetTime(0, FindMinute(), FindSecond());
    return;
}

//Function that return the current second.
unsigned int FindSecond() {
    return clockSecond;
}

//Function that returns the current minute.
unsigned int FindMinute() {
    return clockMinute;
}

//Function that returns the current hour.
unsigned int FindHour() {
    return clockHour;
}

//Function that returns the time as a string for 24 hour clock.
string See24HourClock(unsigned int h, unsigned int m, unsigned int s) {
    string strH = DigitString(h);
    string strM = DigitString(m);
    string strS = DigitString(s);

    return strH + ":" + strM + ":" + strS;
}

//Function that returns the time as a string for the 12 hour format, accounting for AM or PM.
string See12HourClock(unsigned int h, unsigned int m, unsigned int s) {
    string strH = DigitString(h % 12);
    string strM = DigitString(m);
    string strS = DigitString(s);

    if (h == 0 || h == 12)
        strH = DigitString(12);

    if (h < 12)
        return strH + ":" + strM + ":" + strS + " AM";
    return strH + ":" + strM + ":" + strS + " PM";
}

/*
This fucntion adds an extra 0 to a number and changes it to a string for 01 through 09.
Used Google to figure out how to turn an integer to string.
*/
string DigitString(unsigned int n) {
    string strN = to_string(n);
    if (n >= 0 && n <= 9)
        return "0" + strN;
    return strN;
}