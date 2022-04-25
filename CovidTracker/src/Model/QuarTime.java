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

//class for tracking employee object's quarantine statuses
public class QuarTime implements Serializable {

    private Boolean currentStatus;
    private Date qStart;
    private Date qEnd;
    private int daysInQuar;

    //empty constructor with default values
    public QuarTime() {
        currentStatus = true;
        qStart = new Date();
        qEnd = new Date();
        daysInQuar = 0;
    }

    //constructor takes in status, start, and end dates - then calls method to calculate days spent in quarantine
    public QuarTime(Boolean currentStatus, Date qStart, Date qEnd) {
        this.currentStatus = currentStatus;
        this.qStart = qStart;
        this.qEnd = qEnd;
        this.daysInQuar = findDaysSpentInQuarantine(qStart, qEnd);
    }

    //getters and setters
    public Boolean getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Boolean currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Date getqStart() {
        return qStart;
    }

    public void setqStart(Date qStart) {
        this.qStart = qStart;
    }

    public Date getqEnd() {
        return qEnd;
    }

    public void setqEnd(Date qEnd) {
        this.qEnd = qEnd;
    }

    public int getDaysInQuar() {
        return daysInQuar;
    }

    public void setDaysInQuar(int daysInQuar) {
        this.daysInQuar = daysInQuar;
    }

    //toString method for printing
    public String printMe() {
        String s1 = ("\n  Currently Quarantined: " +
                this.getCurrentStatus()
                + "\n" + "  Quarantine Start Date: " + this.getqStart().printMe()
                + "\n" + "  Quarantine End Date: " + this.getqEnd().printMe()
                + "\n" + "  Days spent in Quarantine: " + this.getDaysInQuar());
        return s1;
    }

    //method to print QuarTime objects in CSV compatible String format
    public String printCSVStyle() {
        String s1 = this.getqStart().printMe() + "," + this.getqEnd().printMe() + "," + this.getCurrentStatus().toString()
        + "," + this.getDaysInQuar();
        return s1;
    }

    //method to calculate days spent in quarantine using start and end dates *does not account for leap years*
    public int findDaysSpentInQuarantine(Date start, Date end) {
        int x;

        int[] months = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        int monthA = start.getMonth();
        int dayA = start.getDay();
        int yearA = start.getYear();
        int monthB = end.getMonth();
        int dayB = end.getDay();
        int yearB = end.getYear();

        if (yearA == yearB && monthA == monthB) {
            x = dayB - dayA;
        } else if (yearA == yearB) {
            int firstMonth = months[monthA - 1];
            int secondMonth = months[monthB - 1];
            int secondNumber = secondMonth + dayB;
            int firstNumber = firstMonth + dayA;
            x = secondNumber - firstNumber;
        } else {
            x = 0;
        }
        return x;
    }


    //method to determine if input year is a leap year *not currently in use*
    public boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }
}