/*
Project: COVID-19 Tracker Application
Course: IST 361
Author: Freiwald
Date Developed: 2/11/2022
Last Date Changed: 4/24/22
Revision: 2
 */
package View;

import Controller.AddDelCtrl;
import Controller.EmployeeTableCtrl;
import Controller.MainMenuCtrl;
import Controller.ReportsCtrl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//UI class for users to generate an Excel report of employee objects
public class ReportsUI extends JFrame{
    private JPanel panel1;
    private JLabel titleLbl;
    private JButton genReportBtn;
    private JButton returnBtn;
    private final ReportsCtrl theReportsCtrl;

    //constructor
    public ReportsUI(ReportsCtrl reportsCtrl) {
            this.theReportsCtrl = reportsCtrl;
            this.add(panel1);
            this.setSize(700, 500);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //button used to generate excel file
        genReportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    theReportsCtrl.generateReport();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "CSV File \"Employee_Data\" generated");
            }
        });

        //button used to return user to main menu
        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainMenuCtrl mainMenuCtrl = new MainMenuCtrl();
            }
        });
    }
}
