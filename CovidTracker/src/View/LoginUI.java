/*
Project: COVID-19 Tracker Application
Course: IST 361
Author: Freiwald
Date Developed: 2/11/2022
Last Date Changed: 4/24/22
Revision: 2
 */
package View;

import Controller.LoginCtrl;
import Controller.MainMenuCtrl;
import Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//class creates UI for user login
public class LoginUI extends JFrame {
    private final LoginCtrl theLoginCtrl;
    private JPanel panel1;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private JButton btnSaveNewUser;
    private JButton btnNewUser;
    private JButton btnRtrnToLogin;
    private JButton btnSearchUsers;
    private JLabel titleLbl;

    //constructor for login UI, takes in login controller
    public LoginUI(LoginCtrl loginCtrl) {
        this.theLoginCtrl = loginCtrl;
        this.add(panel1);
        this.setSize(650, 650);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //attempts to log user in with input user account and password, informs user if they do not match
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User(txtUsername.getText(), txtPassword.getText());

                if (theLoginCtrl.requestAuthenticate(user)) {
                    dispose();
                    MainMenuCtrl mainMenuCtrl = new MainMenuCtrl();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username and/or Password");
                    newUserWindow();
                }
            }
        });

        //button closes application
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        //button brings up window to create a new user
        btnNewUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newUserWindow();
                btnSaveNewUser.setVisible(false);
                btnLogin.setVisible(false);
                btnNewUser.setVisible(false);
                btnRtrnToLogin.setVisible(true);
                btnCancel.setVisible(false);
                btnSearchUsers.setVisible(true);
            }
        });

        /*button saves new user with user input values, controller method also checks if username is available,
          and upon successful creation returns to log in screen
        */
        btnSaveNewUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User addMe = new User(txtUsername.getText(), txtPassword.getText());
                theLoginCtrl.addNewUser(addMe);
                newUserWindow();
                JOptionPane.showMessageDialog(null, "New user added successfully!");
                btnSaveNewUser.setVisible(false);
                btnLogin.setVisible(false);
                btnNewUser.setVisible(false);
                btnRtrnToLogin.setVisible(true);
                btnSearchUsers.setVisible(true);

            }
        });

        //returns user to login screen from new user screen
        btnRtrnToLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSaveNewUser.setVisible(false);
                btnLogin.setVisible(true);
                btnNewUser.setVisible(true);
                btnRtrnToLogin.setVisible(false);
                btnCancel.setVisible(true);
                btnSearchUsers.setVisible(false);
            }
        });

        //calls controller method which searches list of users to determine name eligibility
        btnSearchUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                theLoginCtrl.searchForUser(txtUsername.getText());
            }
        });
    }

    //sets text defaults in new user window
    public void newUserWindow() {
        txtUsername.setText("");
        txtPassword.setText("");

    }

    //getters and setters
    public JButton getBtnSaveNewUser() {
        return btnSaveNewUser;
    }

    public void setBtnSaveNewUser(JButton btnSaveNewUser) {
        this.btnSaveNewUser = btnSaveNewUser;
    }


}
