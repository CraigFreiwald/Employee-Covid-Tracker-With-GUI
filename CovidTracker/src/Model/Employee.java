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

//employee class is used for creating employee objects
public class Employee implements Serializable {

    private String lastName;
    private String firstName;
    private String department;
    private Date dateOfBirth;
    private VaccineRecord vr;
    private QuarTime qt;

    //empty constructor
    public Employee() {
        lastName = "default";
        firstName = "default";
        department = "default";
        dateOfBirth = new Date();
        vr = new VaccineRecord();
        qt = new QuarTime();
    }
    //constructor from string, date, vaccine record, and quarantine time inputs
    public Employee(String lastName, String firstName, String department,
                    Date dateOfBirth, VaccineRecord vr, QuarTime qt) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
        this.vr = vr;
        this.qt = qt;
    }

    //getters and setters
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public VaccineRecord getVr() {
        return vr;
    }

    public void setVr(VaccineRecord vr) {
        this.vr = vr;
    }

    public QuarTime getQt() {
        return qt;
    }

    public void setQt(QuarTime qt) {
        this.qt = qt;
    }

    //toString method for printing
    public String printMe() {
        String s1 = ("Employee: \n" +
                "Name: " + this.getFirstName() + " " + this.getLastName()
                + "\n" + "Department: "+this.getDepartment() + "\n" +"DOB: " + this.getDateOfBirth().printMe()
                + "\n" + "Vaccine Records: " + this.getVr().printMe() + "\n" + "Quarantine History/Status: "
                + this.getQt().printMe());
        return s1;
    }

}
