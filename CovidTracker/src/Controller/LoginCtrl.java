/*
Project: COVID-19 Tracker Application
Course: IST 361
Author: Freiwald
Date Developed: 2/11/2022
Last Date Changed: 4/24/22
Revision: 2
 */
package Controller;

import Model.User;
import Model.UserList;
import View.LoginUI;

import javax.swing.*;

//this class is controller for the login UI
public class LoginCtrl {
    private final LoginUI theLoginUI;
    private final UserList theUserList;

    //constructor
    public LoginCtrl() {
        theLoginUI = new LoginUI(this);
        theUserList = new UserList();
        showLoginUI();

    }

    //getter for user array list
    public UserList getUserList() {
        return theUserList;

    }

    //method to set UI to visible
    public void showLoginUI() {
        theLoginUI.setVisible(true);
    }

    //authentication method for user login
    public boolean requestAuthenticate(User user) {
        if (theUserList.authenticate(user)) {
            System.out.println("Valid User");
            return (true);
        } else
            System.out.println("Invalid Username/Password");
        return (false);
    }

    //create new user account method
    public void addNewUser(User user) {
        theUserList.getListOfUsers().add(user);
        theUserList.writeUserListFile();
    }

    //checks if the username is already in use and informs user if choice is available
    public void searchForUser(String searchTerm) {

        for (int i = 0; i < theUserList.getListOfUsers().size(); i++) {

            if (theUserList.getListOfUsers().get(i).getUsername().contains(searchTerm)) {
                System.out.println("Username Taken");
                JOptionPane.showMessageDialog(null, "Username already exists");
                theLoginUI.newUserWindow();
                break;
            } else
                System.out.println("Valid Username/Password");
                JOptionPane.showMessageDialog(null, "Username available, please click \"save new user\"");
                theLoginUI.getBtnSaveNewUser().setVisible(true);
                break;
        }
    }
}

