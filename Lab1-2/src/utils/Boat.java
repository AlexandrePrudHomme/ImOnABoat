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
public class Boat
{

    private int bID;
    private String name;
    private String color;

    public Boat(int bID, String name, String color)
    {
        this.bID = bID;
        this.name = name;
        this.color = color;
    }

    public int getbID()
    {
        return bID;
    }

    public String getName()
    {
        return name;
    }

    public String getColor()
    {
        return color;
    }

}
