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
import Model.Date;
import Model.Employee;
import Model.QuarTime;
import Model.VaccineRecord;
import javax.swing.*;
import java.util.Objects;

/*class is the UI for adding employee objects to serialized file
  includes param checking on user entries to ensure object creation
 */
public class AddEmpUI extends JFrame {
    private JButton btnAdd;
    private JLabel lblLName;
    private JLabel lblFName;
    private JPanel panel1;
    private JLabel lblDept;
    private JLabel lblDOB;
    private JLabel lblVacRec;
    private JLabel lblQuarTime;
    private JTextField txtLName;
    private JTextField txtFName;
    private JTextField txtDOB;
    private JTextField txtShot3;
    private JTextField txtShot1;
    private JTextField txtShot2;
    private JTextField txtEndDate;
    private JTextField txtStartDate;
    private JLabel lblD1;
    private JLabel Name;
    private JLabel AdditionalInfo;
    private JLabel Start;
    private JLabel second;
    private JLabel third;
    private JLabel End;
    private JLabel txtInQuar;
    private JComboBox cmbInQuar;
    private JButton btnRtrn;
    private JComboBox cmbDepartment;
    private JLabel titleLbl;
    private final AddDelCtrl theAddDelCtrl;

    //constructor for UI takes in add del controller object
    public AddEmpUI(AddDelCtrl addDelCtrl) {
            this.theAddDelCtrl = addDelCtrl;
            this.add(panel1);
            this.setSize(1200, 550);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);

            /*Add Button checks params and either adds new employee info to serialized file
             or informs user to correct mistakes in input
            */
            btnAdd.addActionListener(e -> {

                if (txtFName.getText().isEmpty() | txtLName.getText().isEmpty()
                | Objects.equals(txtDOB.getText(), "DD-MM-YYYY") | Objects.equals(txtShot1.getText(), "DD-MM-YYYY")
                | Objects.equals(txtShot2.getText(), "DD-MM-YYYY") | Objects.equals(txtShot3.getText(), "DD-MM-YYYY")
                | Objects.equals(txtEndDate.getText(), "DD-MM-YYYY") | Objects.equals(txtStartDate.getText(), "DD-MM-YYYY"))
                    JOptionPane.showMessageDialog(null, "Some or all fields are filled out" +
                            "incorrectly. Please fill out form in proper format and submit again");
                 else {
                    Date d1 = new Date((txtDOB.getText()));
                    VaccineRecord v1 = new VaccineRecord((new Date(txtShot1.getText())), (new Date(txtShot2.getText())),
                            (new Date(txtShot3.getText())));
                    boolean b1;
                    if (cmbInQuar.getSelectedItem() == "Yes") {
                        b1 = true;
                    } else b1 = false;
                    QuarTime q1 = new QuarTime(b1, (new Date(txtStartDate.getText())),
                            (new Date(txtEndDate.getText())));
                    Employee e1 = new Employee(txtLName.getText(), txtFName.getText(),
                            cmbDepartment.getSelectedItem().toString(), d1, v1, q1);

                    theAddDelCtrl.searchForEmployee(e1);

                    //print to console to test add employee feature
                    System.out.println(e1.printMe());

                    //clear form to default after successful entry
                    clearForm();
                    JOptionPane.showMessageDialog(null, "Employee: " + e1.getFirstName() + " "
                            + e1.getLastName() + " added successfully!");

                }});
            //returns user to employee list menu
            btnRtrn.addActionListener(e -> {
                dispose();
                EmployeeTableCtrl employeeTableCtrl = new EmployeeTableCtrl();
            });

    }
    //method clears form to default values
    public void clearForm(){
        txtLName.setText("");
        txtFName.setText("");
        txtDOB.setText("DD-MM-YYYY");
        txtShot3.setText("DD-MM-YYYY");
        txtShot1.setText("DD-MM-YYYY");
        txtShot2.setText("DD-MM-YYYY");
        txtEndDate.setText("DD-MM-YYYY");
        txtStartDate.setText("DD-MM-YYYY");
    }



}
