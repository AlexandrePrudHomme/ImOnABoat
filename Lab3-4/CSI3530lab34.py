# -*- coding: utf-8 -*-
"""
Created on Wed Nov 21 09:04:44 2018

@author: mouli
"""

import psycopg2
import numpy

class sailor:
    def __init__(self,theID,name,rating,age):
        self.theID = theID
        self.name = name
        self.rating = rating
        self.age = age
        
try:
    # Connection
    connection = psycopg2.connect(user = "postgres",
                                  password = "gotan123",
                                  host = "localhost",
                                  port = "5432",
                                  database = "CSI3530")
    cursor = connection.cursor()
    # Print PostgreSQL Connection properties
    print ( connection.get_dsn_parameters(),"\n")
    # Print PostgreSQL version
    cursor.execute("SELECT version();")
    record = cursor.fetchone()
    print("You are connected to - ", record,"\n")
    
    #Cursor to fetch data from the database
    cursor =  connection.cursor()
    
    #Get all sailors from the database
    get_sailors_query = "SELECT * FROM sailors;"
    
    cursor.execute(get_sailors_query)
    sailors = cursor.fetchall()

    
    #Create a list of sailor object to facilitate the data usage
    listOfSailors = []
    
    for aSailor in sailors:
        listOfSailors.append(sailor(aSailor[0],aSailor[1], aSailor[2], aSailor[3]))

    
    #Get the age of all sailors
    listOfAges = []
    for aSailor in listOfSailors:
        listOfAges.append(aSailor.age)

        
    #Find the age variance
    ageVariance = numpy.var(listOfAges)
    print("The age variance is: " + str(ageVariance) + "\n")
    
    #Find the age standard deviation
    ageStanDev = numpy.std(listOfAges)
    print("The age standard deviation is: " + str(ageStanDev) + "\n")
    
    #Find the average age of sailors
    ageAvr = numpy.average(listOfAges)
    print("The averag age is: " + str(ageAvr) + "\n")
    
    #Find all the sailors in one standard variation from the average
    listOfSailorsInSD = []
    upperBound = ageAvr + ageStanDev
    lowerBound = ageAvr - ageStanDev
    print("This is a list of all the sailors with ages in one standard deviation of the average: ")
    for aSailor in listOfSailors:
        if (aSailor.age < upperBound) and (aSailor.age > lowerBound):
            listOfSailorsInSD.append(aSailor)
            print(str(aSailor.name) + ": " + str(aSailor.age))
    
    
    
    
    
except (Exception, psycopg2.Error) as error :
    print ("Error while connecting to PostgreSQL", error)
finally:
    #closing database connection.
        if(connection):
            cursor.close()
            connection.close()
            print("\nPostgreSQL connection is closed")