Your task is to build an item-tracking program for the Corner Grocer, which should incorporate all of their requested functionality.
The Corner Grocer needs a program that analyzes the text records they generate throughout the day. These records list items purchased in chronological order from the time the store opens to the time it closes. They are interested in rearranging their produce section and need to know how often items are purchased so they can create the most effective layout for their customers.

This program reads an input file and counts the items in that input file, they are then uploaded into a map and the item is displayed with the number of times it appears in the original file next to it. The input file is then closed after the file has been read and the map updated, anopther program is run that takes the information from the map and stores it into an output file called frequency.dat.
A menu appears prompting the user to pick 1 of 4 options, the first option allows the user to input a name and the program will search for that item and display it's frequency. The second option prints a list of the items with their frequency number next to it, the third option prints a list of items in a histogram and the fourth option exits the program.

What did you do particularly well?

I think I did a good job with user validation and writing most of the program in functions which makes it easier to read along with amintain for future use.

Where could you enhance your code? How would these improvements make your code more efficient, secure, and so on?

I feel like I could've done a bettwen job with related the menu items with the specific input, I used a lot of if/else statements which were effective but get clunky and long to use for all of the different options. I could've use try/catch or found a better way to structure it so it was clearer to read and written with less code.

Which pieces of the code did you find most challenging to write, and how did you overcome this? What tools or resources are you adding to your support network?

Writing the functions for creating the map was hard and then taking that map and uploading it to a different file was complicated, I mostly used the internet and zybooks to help my figure out how this worked. Once I started running the code in the main program it made it easier to see where it was faling and what needed to be changed. I would just go through and fix the bugs as they came up and would move things, like variables, around to make the program run smoother.

What skills from this project will be particularly transferable to other projects or course work?

I think a lot of not all of the skils I had to use for this project will be trnasferable, especially being able to use maps, input validation, writing functions and class, and utilizing various c++ libraries to do certain things. I feel like programming relies on being able to read other files and create programs to do things with the infomation or application of those files. I'm sure this project is a basic way of doing that and the more I practice programming, the more I will learn how to use this skill. 

How did you make this program maintainable, readable, and adaptable?

I used header files to define the class with its variables and functions, I used a seperate CPP to write how those programs would function and I kept the main function as clear as I could so it only had to call and use those functions I already defined. I also used proper coding grammer and inline comments to show what I was doing throughout the whole thing.
