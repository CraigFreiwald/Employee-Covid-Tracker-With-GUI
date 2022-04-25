/*
Project: COVID-19 Tracker Application
Course: IST 361
Author: Freiwald
Date Developed: 2/11/2022
Last Date Changed: 4/24/22
Revision: 2
 */
package Model;

import java.io.*;
import java.util.ArrayList;

//employee list class for creating, reading, and using a file listing employees in application
public class EmployeeList {

    private ArrayList<Employee> listOfemployees = new ArrayList<>();
    private String employeeListFileName = "employeesFile.ser";

    //constructor reads current employee list from file, and if it is empty, creates a default list
    public EmployeeList() {

        readEmployeeListFile();
        if (listOfemployees.isEmpty()) {
            createTestEmployeeList();
            writeEmployeeListFile();
            readEmployeeListFile();
        }
        printEmployeesList();

    }
    //method reads employee list file and informs in console if empty
    public void readEmployeeListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(employeeListFileName);
            in = new ObjectInputStream(fis);
            listOfemployees = (ArrayList) in.readObject();
            in.close();
            if (!listOfemployees.isEmpty()) {
                System.out.println("There are no Employees in the file");
            }
        } catch (FileNotFoundException fne) {
            System.out.println("File was not found");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    //method writes the employee list to serialized file
    public void writeEmployeeListFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(employeeListFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfemployees);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //method creates one default employee and adds it to the list
    public void createTestEmployeeList() {
        Employee e1 = new Employee();
        listOfemployees.add(e1);
    }

    //toString method for printing contents of employee list
    public void printEmployeesList() {
        System.out.println("These are the Employees in the Current Employee List");
        for (Employee listOfemployee : listOfemployees) {
            System.out.println(listOfemployee.getFirstName() + " " + listOfemployee.getLastName());
        }
    }

    //names employee list file from String
    public void setEmployeeListFileName(String employeeListFileName) {
        this.employeeListFileName = employeeListFileName;
    }

    //getters and setters
    public ArrayList<Employee> getListOfEmployees() {
        return listOfemployees;
    }

    public void setListOfemployees(ArrayList<Employee> listOfemployees) {
        this.listOfemployees = listOfemployees;
    }

    public String getEmployeeListFileName() {
        return employeeListFileName;
    }


}
