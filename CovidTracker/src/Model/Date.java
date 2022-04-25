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

//date class for use in employee, vaccine record, and quarantine time classes
public class Date implements Serializable {

    private int day;
    private int month;
    private int year;

    //empty constructor
    public Date() {
        day = 0;
        month = 0;
        year = 0;
    }
    //construct date from user input string
    public Date(String s) {
        day = Integer.parseInt(s.substring(0,2));
        month = Integer.parseInt(s.substring(3,5));
        year = Integer.parseInt(s.substring(6,10));
    }
    //construct date from integers
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //getter and setters
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    //toString method for printing
    public String printMe() {
        String s1 = (this.getDay() + "-" + this.getMonth() + "-" + this.getYear());

        return s1;
    }


}
