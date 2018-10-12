/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author mouli
 */
public class Utils {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            new myUtils().createDBInfo();
        }
        catch (IOException e){
            System.out.println("Erreur en trouvaille de fichier: " + e.getMessage());   
        }
    }

    
    
    //gone fission
}
