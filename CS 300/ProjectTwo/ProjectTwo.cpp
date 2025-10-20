// ProjectTwo.cpp 
// Bailey Goodwin
// CS 300

#include <iostream>
#include <vector>
#include <sstream>
#include <fstream>


using namespace std;

// Create stucture for courses
struct Course {
    string courseId;
    string courseName;
    vector<string> prerequisites;
};

// structure for node
struct Node {
    Course course;
    Node* left;
    Node* right;

    // default constructor
    Node() {
        left = nullptr;
        right = nullptr;
    }

    // initialize with a course
    Node(Course aCourse) :
        Node() {
        course = aCourse;
    }
};

// method for displaying courses
void displayCourse(Course course) {
    // outputs the courseId, name, and prerequisites
    cout << course.courseId << ": " << course.courseName << endl;
    cout << "Prerequisites: ";

    // looks to see if there are no prerequisites, if not it outputs a message
    if (course.prerequisites.empty()) {
        cout << "No prerequisites." << endl;
        return;
    }

    // if there are prerequisites, loop through the vector and print each one
    bool first = true;
    for (const auto& prerequisite : course.prerequisites) {
        if (prerequisite.empty()) {
            continue;
        }
        if (!first) {
            cout << ", ";
        }
        cout << prerequisite;
        first = false;
    }

    if (first) {
        cout << "No prerequisites.";
    }
    cout << endl;
    return;
}

// create a class for a binary search tree
class BinarySearchTree {
// initialize private variables
private:
    Node* root;

    void addNode(Node* node, Course course);
    void inOrder(Node* node);

// initiliaze public methods
public:

    BinarySearchTree();
    virtual ~BinarySearchTree();
    void InOrder();
    void Insert(Course course);
    Course Search(string courseId);
};

//default constructor
BinarySearchTree::BinarySearchTree() {
    //initialize housekeeping variables
    root = nullptr;
}

// destructor
BinarySearchTree::~BinarySearchTree() {
    
}

// inorder function
void BinarySearchTree::InOrder() {
    // call inOrder fuction and pass root 
    this->inOrder(root);
}

// insert function
void BinarySearchTree::Insert(Course course) {
    // Implement inserting a course into the tree
    if (root == nullptr) {
        root = new Node(course);
    }
    else {
        // add Node root and course
        this->addNode(root, course);
    }
}

Course BinarySearchTree::Search(string courseId) {
    // Implement searching the tree for a course
    Node* current = root;
    // loop through courses while it is not null
    while (current != nullptr) {
        // if the course id compared is 0 return the course
        if (current->course.courseId.compare(courseId) == 0) {
            return current->course;
        }
        // if it's less than o go left
        if (courseId.compare(current->course.courseId) < 0) {
            current = current->left;
        }
        // else go right
        else {
            current = current->right;
        }
    }
    Course course;
    return course;
}

// function for adding node
void BinarySearchTree::addNode(Node* node, Course course) {
    // Implement inserting a bid into the tree
    // if node is larger then add to left
    if (node->course.courseId.compare(course.courseId) > 0) {
        // if no left node
        if (node->left == nullptr) {
            // this node becomes left
            node->left = new Node(course);
        }
        // else recurse down the left node
        else {
            this->addNode(node->left, course);
        }
    }

    else {
        // if no right node
        if (node->right == nullptr) {
            // this node becomes right
            node->right = new Node(course);
        }
        // else recurse down the right node
        else {
            this->addNode(node->right, course);
        }
    }
}

// inorder function
void BinarySearchTree::inOrder(Node* node) {
    //in order root
    //if node is not equal to null ptr
    if (node != nullptr) {
        //Inorder not left
        inOrder(node->left);
        //output courseId, courseName, and prerequsuites
        displayCourse(node->course);
        //InOder right
        inOrder(node->right);
    }
}

// function for parsing data
vector<vector<string>> Parser(const string& csvPath) {
    // opens the file for the csv path
    ifstream file(csvPath);
    // creates error message if the file could not open approrpriately
    if (!file.is_open()) {
        cout << "Error: The file did not open properly!" << endl;
        return {};
    }

    // creates vector for rows
    vector<vector<string>> rows;
    // initialize variables needed
    string line;
    int lineNumber = 0;

    // loops through the file information
    while (getline(file, line)) {
        // adds a line number if there's a new line
        lineNumber = lineNumber + 1;

        //continues if it's an empty line
        if (line.empty()) {
            continue;
        }

        // declares a vector thst holds each section
        vector<string>section;
        string value;

        // loops through characters to seperate comma values
        for (char c : line) {
            if (c == ',') {
                section.push_back(value);
                value.clear();
            }
            else {
                value = value + c;
            }
        }

        // adds the value to the section vector
        section.push_back(value);

        // if the section size is less than 2, output an error and continue
        if (section.size() < 2) {
            cout << "Error: line " << lineNumber << " has too few values!" << endl;
            continue;
        }

        // adds the section to rows vector
        rows.push_back(section);
    }

    // close file and return rows
    file.close();
    return rows;
}

// function for validating courses
bool ValidateCourses(const vector<vector<string>>& rows) {
    // create a vector with courseId's
    vector<string> courseId;

    // loop through rows to put courseId into a vector
    for (const auto& row : rows) {
        if (!row.empty()) {
            courseId.push_back(row[0]);
        }
    }

    // create boolean variable real courses to be true
    bool realCourses = true;

    // check courseId's against prerequisites
    for (size_t i = 0; i < rows.size(); ++i) {
        const auto& row = rows[i];
        if (row.size() > 2) {
            for (size_t j = 2; j < row.size(); ++j) {
                //set each value greater than 2 as a prerequisite
                string prerequisite = row[j];
                // set a boolean variable found to false
                if (prerequisite.empty()) {
                    continue;
                }
                bool found = false;
                for (const string& id : courseId) {
                    if (id == prerequisite) {
                        found = true;
                        break;
                    }
                }

                // if the values aren't found and match, output error message
                if (!found) {
                    cout << "Error: line " << (i + 1) << " contains a prerequisite that does not exist!" << endl;
                    realCourses = false;
                }
            }
        }
    }

    // output success message
    if (realCourses) {
        cout << "All prerequisites exist and match a course Id!" << endl;
    }

    return realCourses;
}

// Create function for loading courses
void loadCourses(string csvPath, BinarySearchTree* bst) {
    cout << "Loading CSV file " << csvPath << endl;

    // call the parsers to go through data and put it into vector rows
    vector<vector<string>> rows = Parser(csvPath);

    // output message if the data is empty
    if (rows.empty()) {
        cout << "Error: No data or the file failed to open!" << endl;
        return;
    }

    //validate courses before loading the data
    if (!ValidateCourses(rows)) {
        cout << "Validation failed, stopping the loading process." << endl;
        return;
    }

    try {
        // loop through all of the rows to create course object and insert into binary search tree
        for (size_t i = 0; i < rows.size(); ++i) {
            const auto& row = rows[i];

            // set up error if the row is less than 2
            if (row.size() < 2) {
                cout << "Error: line is too small, skipping to the next one." << endl;
                continue;
            }

            // create course object
            Course course;
            course.courseId = row[0];
            course.courseName = row[1];

            // add prerequisites if applicable
            if (row.size() > 2) {
                for (size_t j = 2; j < row.size(); ++j) {
                    course.prerequisites.push_back(row[j]);
                }
            }

            // insert the course into the binary search tree
            bst->Insert(course);
        }
    }
    catch (exception& e){
        cerr << "Error while loading CSV: " << e.what() << endl;
    }

    // output finish message
    cout << "Finished loading courses into the tree." << endl;
}

// main function with main menu
int main() {
    // Define a timer variable
    clock_t ticks;

    // Define a binary search tree to hold all bids
    BinarySearchTree* bst;
    bst = new BinarySearchTree();
    Course course;
    string path;
    string courseId;

    int choice = 0;
    while (choice != 9) {
        cout << "Menu:" << endl;
        cout << "  1. Load Courses" << endl;
        cout << "  2. Display All Courses" << endl;
        cout << "  3. Find Course" << endl;
        cout << "  9. Exit" << endl;
        cout << "Enter choice: ";

        // creates input validation for choice
        if (!(cin >> choice)) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Invalid input, please enter a number!" << endl;
            continue;
        }

        switch (choice) {

        case 1:

            cout << "Please enter the file name to load: ";
            cin >> ws;
            getline(cin, path);

            // outputs error message if file is empty
            if (path.empty()) {
                cout << "File is empty.";
                break;
            }

            // Initialize a timer variable before loading courses
            ticks = clock();

            // call load courses function
            loadCourses(path, bst);

            // Calculate elapsed time and display result
            ticks = clock() - ticks; // current clock ticks minus starting clock ticks
            cout << "time: " << ticks << " clock ticks" << endl;
            cout << "time: " << ticks * 1.0 / CLOCKS_PER_SEC << " seconds" << endl;
            break;

        case 2:
            cout << "Courses in order:" << endl;
            bst->InOrder();
            break;

        case 3:

            cout << "Enter Course ID to look for: ";
            cin >> ws;
            getline(cin, courseId);

            ticks = clock();

            course = bst->Search(courseId);

            // output error message if file is empty
            if (!course.courseId.empty()) {
                displayCourse(course);
            }
            else {
                cout << "Course Id " << courseId << " not found." << endl;
            }

            ticks = clock() - ticks; // current clock ticks minus starting clock ticks

            cout << "time: " << ticks << " clock ticks" << endl;
            cout << "time: " << ticks * 1.0 / CLOCKS_PER_SEC << " seconds" << endl;

            break;
        }
    }

    cout << "Good bye." << endl;

    return 0;
}


