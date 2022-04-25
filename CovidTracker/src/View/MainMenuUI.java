/*
Project: COVID-19 Tracker Application
Course: IST 361
Author: Freiwald
Date Developed: 2/11/2022
Last Date Changed: 4/24/22
Revision: 2
 */
package View;


import Controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//class creates main menu UI
public class MainMenuUI extends JFrame{
    private MainMenuCtrl mainMenuCtrl;
    private JPanel panel2;
    private JButton btnEmployeeList;
    private JButton btnReports;
    private JButton btnLogout;
    private JLabel headerLbl;
    private JLabel titleLbl;

    //constructor for main menu UI, takes in main menu controller
    public MainMenuUI(MainMenuCtrl mainMenuCtrl) {
        this.mainMenuCtrl = mainMenuCtrl;
        this.add(panel2);
        this.setSize(700, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //forwards control to employee list UI
        btnEmployeeList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                EmployeeTableCtrl employeeTableCtrl = new EmployeeTableCtrl();
            }
        });

        //forwards control to report UI
        btnReports.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ReportsCtrl reportsCtrl = new ReportsCtrl();
            }
        });

        //forwards control to login UI
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginCtrl loginCtrl = new LoginCtrl();

            }
        });

    }
}
