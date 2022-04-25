/*
Project: COVID-19 Tracker Application
Course: IST 361
Author: Freiwald
Date Developed: 2/11/2022
Last Date Changed: 4/24/22
Revision: 2
 */
package Controller;

import Model.Employee;
import Model.EmployeeList;
import Model.EmployeeTableModel;
import View.EmployeeTableUI;

import javax.swing.*;
//this class is controller for the employee table UI
public class EmployeeTableCtrl {
    private EmployeeList employeeList = new EmployeeList();
    private EmployeeTableModel employeeTableModel;
    private EmployeeTableUI employeeTableUI;

    //constructor
    public EmployeeTableCtrl(){
        this.employeeTableModel = new EmployeeTableModel(this.employeeList.getListOfEmployees());
        this.employeeTableUI = new EmployeeTableUI(this);
        this.employeeTableUI.setVisible(true);
    }

    //displays employee details in a popup window
    public void showEmployeeDetail(int selected) {
        Employee e1 = employeeList.getListOfEmployees().get(selected);
        JOptionPane.showMessageDialog(null, e1.printMe());
    }

    //removes selected employee from list view
    public void deleteCurrentEmployee(int selected) {
        Employee e1 = employeeList.getListOfEmployees().remove(selected);
        this.employeeList.writeEmployeeListFile();
        JOptionPane.showMessageDialog(null, "Employee: " + e1.getFirstName() + " "
                + e1.getLastName() + " has been removed successfully");

        //dispose current window and refresh the list view to reflect removed employee
        employeeTableUI.dispose();
        this.employeeTableModel = new EmployeeTableModel(this.employeeList.getListOfEmployees());
        this.employeeTableUI = new EmployeeTableUI(this);
        this.employeeTableUI.setVisible(true);
    }

    //getter for employee table model
    public EmployeeTableModel getEmployeeTableModel() {
        return employeeTableModel;
    }

}
