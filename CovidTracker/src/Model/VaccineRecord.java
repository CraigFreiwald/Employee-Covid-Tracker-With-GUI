/*
Project: COVID-19 Tracker Application
Course: IST 361
Author: Freiwald
Date Developed: 2/11/2022
Last Date Changed: 4/24/22
Revision: 2
 */
package Model;

import java.io.Serializable;

//class to create vaccine records for employee objects
public class VaccineRecord implements Serializable {

    private Date v1Date;
    private Date v2Date;
    private Date v3Date;

    //empty constructor with default values
    public VaccineRecord() {
        v1Date = new Date();
        v2Date = new Date();
        v3Date = new Date();
    }

    //constructor that takes in three vaccine dates
    public VaccineRecord(Date v1Date, Date v2Date, Date v3Date) {
        this.v1Date = v1Date;
        this.v2Date = v2Date;
        this.v3Date = v3Date;
    }

    //getters and setters
    public Date getV1Date() {
        return v1Date;
    }

    public void setV1Date(Date v1Date) {
        this.v1Date = v1Date;
    }

    public Date getV2Date() {
        return v2Date;
    }

    public void setV2Date(Date v2Date) {
        this.v2Date = v2Date;
    }

    public Date getV3Date() {
        return v3Date;
    }

    public void setV3Date(Date v3Date) {
        this.v3Date = v3Date;
    }

    //method for printing
    public String printMe() {
        String s1 = ("\n  1st Dose: " + this.getV1Date().printMe()
                + "\n" + "  2nd Dose: " +this.getV2Date().printMe()
                + "\n" + "  3rd Dose: " +this.getV3Date().printMe());
        return s1;
    }

    //method for printing to CSV compatible String format
    public String printCSVStyle() {
        String s1 = this.getV1Date().printMe() + "," + this.getV2Date().printMe() + "," + this.getV3Date().printMe();
        return s1;
    }

}
