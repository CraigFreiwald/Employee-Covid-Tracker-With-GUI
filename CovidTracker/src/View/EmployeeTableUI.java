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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*creates UI object for displaying all employees in current file to a table in view,
  provides details upon selection and has buttons to add or delete employees from the current file
*/
public class EmployeeTableUI extends JFrame {
    private JLabel titleLbl;
    private JPanel tablePanel;
    private JPanel buttonPanel;
    private JTable employeeTable;
    private JButton detailsButton;;
    private JButton mainMenuButton;
    private JButton deleteEmployeeButton;
    private JButton addEmployeeButton;
    private JScrollPane tableScroller;
    private EmployeeTableCtrl employeeTableCtrl;


    //constructor takes in employee table controller and calls method to initialize UI components
    public EmployeeTableUI(EmployeeTableCtrl employeeTableCtrl) {
        this.employeeTableCtrl = employeeTableCtrl;
        this.initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //method initializes all UI components
    public void initComponents() {
        this.tablePanel = new JPanel();
        this.buttonPanel = new JPanel(new GridLayout(1, 4));
        this.employeeTable = new JTable(this.employeeTableCtrl.getEmployeeTableModel());
        this.employeeTable.getColumnModel().getColumn(0).setPreferredWidth(35);
        this.employeeTable.getColumnModel().getColumn(1).setPreferredWidth(35);
        this.employeeTable.getColumnModel().getColumn(2).setPreferredWidth(35);
        this.employeeTable.getColumnModel().getColumn(3).setPreferredWidth(35);
        this.titleLbl = new JLabel("Employee List");
        this.detailsButton = new JButton("Show Details");
        this.mainMenuButton = new JButton("Return to Main Menu");
        this.deleteEmployeeButton = new JButton("Remove Employee");
        this.addEmployeeButton = new JButton("Add Employee");
        this.detailsButton.addActionListener(new EmployeeTableUI.DetailsButtonListener());
        this.mainMenuButton.addActionListener(new EmployeeTableUI.MainMenuButtonListener());
        this.deleteEmployeeButton.addActionListener(new EmployeeTableUI.DeleteEmployeeButtonListener());
        this.addEmployeeButton.addActionListener(new EmployeeTableUI.AddEmployeeButtonListener());
        this.tableScroller = new JScrollPane(this.employeeTable);
        this.employeeTable.setFillsViewportHeight(true);
        this.tableScroller.setVerticalScrollBarPolicy(22);
        this.tableScroller.setPreferredSize(new Dimension(500, 500));
        this.tablePanel.add(this.tableScroller);
        this.tablePanel.add(this.titleLbl);
        this.setSize(650, 600);
        this.setLocationRelativeTo((Component)null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(this.buttonPanel, "South");
        this.getContentPane().add(this.tablePanel, "Center");
        this.buttonPanel.add(this.addEmployeeButton);
        this.buttonPanel.add(this.deleteEmployeeButton);
        this.buttonPanel.add(this.detailsButton);
        this.buttonPanel.add(this.mainMenuButton);


    }

    //button brings up UI page to input new employee to add to list and file
    public class AddEmployeeButtonListener implements ActionListener {
        public AddEmployeeButtonListener() {
        }

        public void actionPerformed(ActionEvent e) {
            EmployeeTableUI.this.dispose();
            new AddDelCtrl();
        }
    }
    //button calls controller method to remove selected employee from current file
    public class DeleteEmployeeButtonListener implements ActionListener {
        public DeleteEmployeeButtonListener() {
        }

        public void actionPerformed(ActionEvent e) {

            int selectedTableRow = EmployeeTableUI.this.employeeTable.getSelectedRow();
            int selectedModelRow = EmployeeTableUI.this.employeeTable.convertRowIndexToModel(selectedTableRow);
            if (selectedModelRow < 0) {
                selectedModelRow = 0;
            }

            EmployeeTableUI.this.employeeTableCtrl.deleteCurrentEmployee(selectedModelRow);

        }
    }

    //button calls controller method to display details of selected employee in table
    public class DetailsButtonListener implements ActionListener {
        public DetailsButtonListener() {
        }

        public void actionPerformed(ActionEvent e) {
            int selectedTableRow = EmployeeTableUI.this.employeeTable.getSelectedRow();
            int selectedModelRow = EmployeeTableUI.this.employeeTable.convertRowIndexToModel(selectedTableRow);
            if (selectedModelRow < 0) {
                selectedModelRow = 0;
            }

            EmployeeTableUI.this.employeeTableCtrl.showEmployeeDetail(selectedModelRow);
        }
    }

    //button disposes of current view and creates a new main menu object to return user to main menu
    public class MainMenuButtonListener implements ActionListener {
        public MainMenuButtonListener() {
        }

        public void actionPerformed(ActionEvent e) {
            EmployeeTableUI.this.dispose();
            new MainMenuCtrl();
        }
    }

}

