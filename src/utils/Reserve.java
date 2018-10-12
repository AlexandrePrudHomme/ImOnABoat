/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Date;

/**
 *
 * @author Julien
 */
public class Reserve
{

    private int sID;
    private int bID;
    private Date date;

    public Reserve(int sID, int bID, Date date)
    {
        this.sID = sID;
        this.bID = bID;
        this.date = date;
    }

    public int getsID()
    {
        return sID;
    }

    public int getbID()
    {
        return bID;
    }

    public Date getDate()
    {
        return date;
    }

}
