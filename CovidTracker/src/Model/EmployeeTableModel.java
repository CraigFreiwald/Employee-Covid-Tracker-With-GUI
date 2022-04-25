/*
Project: COVID-19 Tracker Application
Course: IST 361
Author: Freiwald
Date Developed: 2/11/2022
Last Date Changed: 4/24/22
Revision: 2
 */
package Model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

//class creates a model for the employee table view
public class EmployeeTableModel extends AbstractTableModel {
    private String[] columnNames = new String[]{"Last Name", "First Name", "Department", "DOB"};
    private ArrayList<Employee> employeeArrayList;

    //constructor for employee table model takes in an employee array list for processing in to view
    public EmployeeTableModel(ArrayList<Employee> newEmployeeArrayList) {
        this.employeeArrayList = newEmployeeArrayList;
    }

    //provides row count to model
    @Override
    public int getRowCount() {
        return this.employeeArrayList.size();
    }

    //provides column count to model
    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    //provides individual employee object data to the model for view
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return ((Employee) this.employeeArrayList.get(rowIndex)).getLastName();
            case 1:
                return ((Employee) this.employeeArrayList.get(rowIndex)).getFirstName();
            case 2:
                return ((Employee) this.employeeArrayList.get(rowIndex)).getDepartment();
            case 3:
                return ((Employee) this.employeeArrayList.get(rowIndex)).getDateOfBirth().printMe();
            default:
                return null;
        }
    }

    //getter for column names
    public String getColumnName(int col) {
        return this.columnNames[col];
    }

}
