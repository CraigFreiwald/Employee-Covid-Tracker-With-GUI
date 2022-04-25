/*
Project: COVID-19 Tracker Application
Course: IST 361
Author: Freiwald
Date Developed: 2/11/2022
Last Date Changed: 4/24/22
Revision: 2
 */
package Model;

//class used to test model classes
public class TestHarness {

    //constructor
    public TestHarness() {
        testUserClass();
        testDateClass();
        testVaccineRecordClass();
        testQuarTimeClass();
        testEmployeeClass();
        testUserListClass();

    }

    //tests creating a user
    public void testUserClass() {
        System.out.println("Testing User Class");

        User u1 = new User("John345", "12345@#$");

        if (u1 != null) {
            System.out.println("Test of Model.User created Successfully");
        } else {
            System.out.println("There was an error in creating the Model.User object");
        }

    }

    //tests creating a date
    public void testDateClass() {
        System.out.println("Testing Date Class");

        Date d1 = new Date(01, 02, 2022);

        if (d1 != null) {
            System.out.println("Test of Model.Date created Successfully");
        } else {
            System.out.println("There was an error in creating the Model.Date object");
        }

    }

    //tests creating a vaccine record
    public void testVaccineRecordClass() {
        System.out.println("Testing VaccineRecord Class");
        Date d1 = new Date(01, 02, 2022);
        VaccineRecord v1 = new VaccineRecord(d1, d1, d1);

        if (v1 != null) {
            System.out.println("Test of Model.VaccineRecord created Successfully");
        } else {
            System.out.println("There was an error in creating the Model.VaccineRecord object");
        }

    }

    //tests creating a quarantine time object
    public void testQuarTimeClass() {
        System.out.println("Testing QuarTime Class");
        Date d1 = new Date(01, 02, 2022);
        QuarTime q1 = new QuarTime(true, d1, d1);

        if (q1 != null) {
            System.out.println("Test of Model.QuarTime created Successfully");
        } else {
            System.out.println("There was an error in creating the Model.QuarTime object");
        }

    }

    //tests creating an employee
    public void testEmployeeClass() {
        System.out.println("Testing Employee Class");
        Date d1 = new Date(01, 02, 2022);
        VaccineRecord v1 = new VaccineRecord(d1, d1, d1);
        QuarTime q1 = new QuarTime(true, d1, d1);
        Employee e1 = new Employee("Doe", "John", "Sales", d1, v1, q1);

        if (e1 != null) {
            System.out.println("Test of Model.Employee created Successfully");
        } else {
            System.out.println("There was an error in creating the Model.Employee object");
        }

    }

    //tests creating a user list
    public void testUserListClass() {
        System.out.println("Testing Userlist Class");
        UserList list = new UserList();

        if (list != null) {
            System.out.println("Test of Model.UserList created Successfully");
        } else {
            System.out.println("There was an error in creating the Model.UserList object");
        }

    }
}
