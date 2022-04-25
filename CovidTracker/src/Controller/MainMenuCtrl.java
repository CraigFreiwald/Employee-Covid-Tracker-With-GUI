/*
Project: COVID-19 Tracker Application
Course: IST 361
Author: Freiwald
Date Developed: 2/11/2022
Last Date Changed: 4/24/22
Revision: 2
 */
package Controller;

import View.MainMenuUI;
//this class is controller for the main menu after login
public class MainMenuCtrl {
    private MainMenuUI theMainMenuUI;

    //constructor
    public MainMenuCtrl() {
        theMainMenuUI = new MainMenuUI(this);
        showMainMenuUI();
    }

    //getters and setters
    public MainMenuUI getTheMainMenuUI() {
        return theMainMenuUI;
    }

    public void setTheMainMenuUI(MainMenuUI theMainMenuUI) {
        this.theMainMenuUI = theMainMenuUI;
    }

    //sets UI to visible
    public void showMainMenuUI(){
        theMainMenuUI.setVisible(true);
    }
}
