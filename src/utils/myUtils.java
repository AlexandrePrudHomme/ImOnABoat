/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Julien
 */
public class myUtils
{
    public void createDBInfo() throws IOException {
        BufferedWriter out = null;

        try {
            FileWriter fstream = new FileWriter("out.txt", false); //true tells to append data.
            out = new BufferedWriter(fstream);
            List<String> allNames = Files.readAllLines(Paths.get("E:\\Users\\Julien\\NetBeansProjects\\Utils\\src\\utils\\male.txt"));
            List<Sailor> allSailors = new LinkedList<>(); 
            
            out.write("CREATE TABLE Sailors ("
                    + "sID INTEGER,"
                    + " sname STRING,"
                    + " rating INTEGER,"
                    + " age REAL);");
            out.newLine();
            
            Sailor mySailor = null;
            for(int i = 1; i < allNames.size()+1; i++){
                mySailor = createSailor(i, allNames.get(i-1));
                allSailors.add(mySailor);
                out.write("INSERT INTO Sailors VALUES (" + 
                        String.valueOf(mySailor.getsID())+ 
                        "," + mySailor.getName() + 
                        "," + String.valueOf(mySailor.getRating()) + 
                        "," + String.valueOf(mySailor.getAge()) + ");");
                out.newLine();
            }
            
            out.newLine();
            
            List<String> allBoatName = Files.readAllLines(Paths.get("E:\\Users\\Julien\\NetBeansProjects\\Utils\\src\\utils\\boat.txt"));
            List<String> allColors = Files.readAllLines(Paths.get("E:\\Users\\Julien\\NetBeansProjects\\Utils\\src\\utils\\color.txt"));
            List<Boat> allBoats = new LinkedList<>(); ;
            
            out.write("CREATE TABLE Boats ("
                    + "bID INTEGER,"
                    + " bName INTEGER,"
                    + " color STRING);");
            out.newLine();
            
            Boat myBoat = null;
            for (int i = 1; i < allBoatName.size()+1; i++){
                myBoat = new Boat(i, allBoatName.get(i-1), allColors.get(i%allColors.size()));
                allBoats.add(myBoat);
                out.write("INSERT INTO Boats VALUES ("
                    + String.valueOf(myBoat.getbID()) 
                    + ", " + myBoat.getName()
                    + ", " + myBoat.getColor() + ");");
                out.newLine();
            }
            
            out.newLine();
            out.write("CREATE TABLE Reserves ("
                    + "sID INTEGER,"
                    + " bID INTEGER,"
                    + " resDate DATE);");
            out.newLine();

            for (int i = 0; i < 10000; i++){
                int theSID = (new Random().nextInt(allSailors.size()) + 1);
                int theBID = (new Random().nextInt(allBoats.size()) + 1);
                Date theDate = randomDate();
                out.write("INSERT INTO Reserves ("
                        + String.valueOf(theSID) + 
                        ", " + String.valueOf(theBID) +
                        ", " + theDate.toString() + ");");
                out.newLine();
            }
            
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
        
    }
    
    public static Sailor createSailor(int sID, String name){
        return new Sailor(sID, name, rand1to10(), rand15to60());
    }
    
    public static double rand1to10(){
        return (int) (Math.random()*(11));
    }
    public static int rand15to60(){
        return (int) (Math.random()*(46))+15;
    }

    public Date randomDate(){
        Date D1 = new Date(95,04,15);
        long range = new Date(118,10,12).getTime() - D1.getTime();
        long rand = new Random().nextLong();
        return new Date(D1.getTime()+(rand%range));
    }
    //gone fission
}
