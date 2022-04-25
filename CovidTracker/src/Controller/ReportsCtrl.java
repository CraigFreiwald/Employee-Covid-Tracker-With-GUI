/*
Project: COVID-19 Tracker Application
Course: IST 361
Author: Freiwald
Date Developed: 2/11/2022
Last Date Changed: 4/24/22
Revision: 2
 */
package Controller;

import Model.EmployeeList;
import Model.EmployeeReports;
import View.ReportsUI;

import java.io.IOException;


//this class is controller for the reports UI
public class ReportsCtrl {
    private final ReportsUI theReportsUI;
    private final EmployeeList theEmployeeList;

    //constructor
    public ReportsCtrl() {
        theReportsUI = new ReportsUI(this);
        theEmployeeList = new EmployeeList();
        showReportsUI();
    }

    //sets ReportsUI to visible
    public void showReportsUI(){
        theReportsUI.setVisible(true);
    }

    //used to access model data and generate CSV file
    public void generateReport() throws IOException {
        try {
            EmployeeReports employeeReports = new EmployeeReports();
        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }
}
