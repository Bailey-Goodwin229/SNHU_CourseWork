# Example Python Code to Insert a Document 

from pymongo import MongoClient 
from bson.objectid import ObjectId 
from pymongo.errors import PyMongoError

class AnimalShelter(object): 
    """ CRUD operations for Animal collection in MongoDB """ 

    def __init__(self, username, password): 
        # Initializing the MongoClient. This helps to access the MongoDB 
        # databases and collections. This is hard-wired to use the aac 
        # database, the animals collection, and the aac user. 
        # 
        # You must edit the password below for your environment. 
        # 
        # Connection Variables 
        # 
        USER = 'aacuser' 
        PASS = 'mongodb' 
        HOST = 'localhost' 
        PORT = 27017 
        DB = 'aac' 
        COL = 'animals' 
        # 
        # Initialize Connection 
        # 
        self.client = MongoClient('mongodb://%s:%s@%s:%d/?authSource=admin' % (USER,PASS,HOST,PORT)) 
        self.database = self.client['%s' % (DB)] 
        self.collection = self.database['%s' % (COL)] 

    # Create a method to return the next available record number for use in the create method
            
    # Complete this create method to implement the C in CRUD. 
    def create(self, data):
        
        # Inserts a document into the the specified MongoDB Collection
        # Data = dictionary with Key/Value pairs
        # Returns the data if true or else false
        
        if data is not None: 
            # Tries to insert data first to see if it works
            try:
                self.collection.insert_one(data)  # data should be dictionary
                return True
            # if insertion fails then it gets sent to here, displays message and returns false
            except PyMongoError as e:
                print(f"An error occurred during insertion process: {e}")
                return False
        # or else there was not data to be inserted        
        else: 
            raise Exception("Nothing to save, because data parameter is empty") 

    # Create method to implement the R in CRUD.
    def read(self, query):
        
        # Queries for the documents in the MongoDB collection
        # Query = dictionary containing Key/Value pairs
        # Returns a list of results if successful or else it returns an empty list
        
         # Checks if query is None to prevent returning all documents accidentally
        if query is not None:
            # Tries to find a return cursor, then converts it to a list
            try:
                # Uses find() 
                cursor = self.collection.find(query)
                return list(cursor)
            # if there's an error it gets caught here with a display message and returns empty list
            except PyMongoError as e:
                print(f"An error occurred during query: {e}")
                return []
        else:
            # Else the query is empty, create exception with display error method
            raise Exception("Nothing to read, because query parameter is None")
        
    def update(self, query, data):
        
        # Function to update documents in the MongoDB collection
        # Query = dictionary containing Key/Value pairs
        # Data = dictionay with new set of values
        # Returns number of documents updated
        
        if query is not None:
            # If there is a query, then try to update
            try:
                # Using update_many to handle one or multiple documents
                # '$set' ensures we only change the specific fields provided
                result = self.collection.update_many(query, {"$set": data})
                return result.modified_count
            # If there is an error, catch it here and display message with a return of 0
            except PyMongoError as e:
                print(f"An error occured during update: {e}")
                return 0
        else:
            # Else the query is empty, create exception with display error method
            raise Exception("Query is empty")
            
    def delete(self, query):
        
        # Function that deletes a document from the MongoDB collection
        # Query = dictionary containing Key/Value pairs
        # Returns the number of documents removed
        
        if query is not None:
            # If there is a query, then try to delete
            try:
                # Uses the delete_many as that is the standard
                result = self.collection.delete_many(query)
                return result.deleted_count
            except PyMongoError as e:
                # If there is an error, catch it here and display message with a return of 0
                print(f"An error occurred during deletion: {e}")
                return 0
        else:
            # Else the query is empty, create exception with display error method
            raise Exception("Query is empty")
            