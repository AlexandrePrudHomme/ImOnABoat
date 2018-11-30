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
    
    cursor =  connection.cursor()
    
    get_sailors_query = "SELECT * FROM sailors;"
    
    cursor.execute(get_sailors_query)
    sailors = cursor.fetchall()
    print(sailors)
    listOfSailors = []
    
    for aSailor in sailors:
        listOfSailors.append(sailor(aSailor[0],aSailor[1], aSailor[2], aSailor[3]))
        print(listOfSailors[-1].theID)
    
    listOfAges = []
    for aSailor in listOfSailors:
        listOfAges.append(aSailor.age)
        print(aSailor.age)
        
    ageVariance = numpy.var(listOfAges)
    print(str(ageVariance) + "\n")
    
    ageStanDev = numpy.std(listOfAges)
    print(str(ageStanDev) + "\n")
    
    ageAvr = numpy.average(listOfAges)
    print(str(ageAvr) + "\n")
    
    listOfSailorsInSD = []
    
    upperBound = ageAvr + ageStanDev
    lowerBound = ageAvr - ageStanDev
    for aSailor in listOfSailors:
        if (aSailor.age < upperBound) and (aSailor.age > lowerBound):
            listOfSailorsInSD.append(aSailor)
            print(str(aSailor.age) + "\n")
    
    
    
    
    
except (Exception, psycopg2.Error) as error :
    print ("Error while connecting to PostgreSQL", error)
finally:
    #closing database connection.
        if(connection):
            cursor.close()
            connection.close()
            print("PostgreSQL connection is closed")