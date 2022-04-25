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

//class is used to generate a CSV type file for users to export employee data and use in spreadsheet programs
public class EmployeeReports {

    //headers for CSV file
    private String headers = "Last Name,First Name,DOB,Department,Vaccine 1,Vaccine 2,Vaccine 3,Start Quarantine," +
            "End Quarantine,Currently Quarantined, Days in Quarantine";

    //Employee list to write to CSV file
    private EmployeeList employeeList = new EmployeeList();

    //constructor tries to write CSV file with current Employee List
    public EmployeeReports() throws IOException {
        FileWriter fileWriter = new FileWriter("./Employee_Data.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        try {
            bufferedWriter.write(headers + "\n");

            for (Employee e : employeeList.getListOfEmployees()) {
                bufferedWriter.write(writeEmployeeForFile(e));
            }
            bufferedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("File updated successfully!");
    }

    //method to prepare Employee objects in to CSV compatible strings
    public String writeEmployeeForFile(Employee e){
        StringBuilder sb = new StringBuilder();

        sb.append(e.getLastName());
        sb.append(",");
        sb.append(e.getFirstName());
        sb.append(",");
        sb.append(e.getDateOfBirth().printMe());
        sb.append(",");
        sb.append(e.getDepartment());
        sb.append(",");
        sb.append(e.getVr().printCSVStyle());
        sb.append(",");
        sb.append(e.getQt().printCSVStyle());
        sb.append("\n");

        return sb.toString();
    }
}
