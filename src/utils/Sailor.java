/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Julien
 */
public class Sailor
{

    private int sID;
    private String name;
    private double rating;
    private int age;

    public Sailor(int sID, String name, double rating, int age)
    {
        this.sID = sID;
        this.name = name;
        this.rating = rating;
        this.age = age;
    }

    public int getsID()
    {
        return this.sID;
    }

    public String getName()
    {
        return this.name;
    }

    public double getRating()
    {
        return this.rating;
    }

    public int getAge()
    {
        return this.age;
    }
}
