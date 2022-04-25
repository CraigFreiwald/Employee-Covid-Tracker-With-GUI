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
import View.AddEmpUI;

import javax.swing.*;
//This class is a controller for the Add Employee UI
public class AddDelCtrl {
    private final AddEmpUI theAddDelUI;
    private final EmployeeList theEmployeeList;

    //constructor
    public AddDelCtrl() {
        theAddDelUI = new AddEmpUI(this);
        theEmployeeList = new EmployeeList();
        showAddDelUI();
    }

    //method to make UI visible
    public void showAddDelUI(){
        theAddDelUI.setVisible(true);
    }

    //employee array list getter
    public EmployeeList getTheEmployeeList() {
        return theEmployeeList;
    }

    //adds employee to serialized file
    public void addNewEmployee(Employee employee) {
        theEmployeeList.getListOfEmployees().add(employee);
        theEmployeeList.writeEmployeeListFile();
    }
    //method used for view button, also adds employee to serialized file using above method
    public void searchForEmployee(Employee empl) {

        for (int i = 0; i < theEmployeeList.getListOfEmployees().size(); i++) {

            if (theEmployeeList.getListOfEmployees().get(i).getFirstName().matches(empl.getFirstName())
                && theEmployeeList.getListOfEmployees().get(i).getLastName().matches(empl.getLastName())) {
                JOptionPane.showMessageDialog(null, "Employee Already Exists in System");
                break;
            } else
                addNewEmployee(empl);
                break;
        }
    }
    //removes employee from serialized file
    public void deleteEmployee(Employee employee){
        theEmployeeList.getListOfEmployees().remove(employee);
        theEmployeeList.writeEmployeeListFile();
    }

}

