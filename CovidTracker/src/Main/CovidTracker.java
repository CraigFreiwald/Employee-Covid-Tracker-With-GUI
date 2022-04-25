/*
Project: COVID-19 Tracker Application
Course: IST 361
Author: Freiwald
Date Developed: 2/11/2022
Last Date Changed: 4/24/22
Revision: 2
 */
package Main;

import Controller.AddDelCtrl;
import Controller.LoginCtrl;
import Controller.MainMenuCtrl;
import Model.EmployeeReports;
import Model.TestHarness;

import java.io.IOException;

//this is the main class which launches the application and contains the main method
public class CovidTracker {

    public static void main(String[] args) {
        //Login Security can be bypassed by uncommenting the first line and commenting out the second line
            //MainMenuCtrl mainMenuCtrl = new MainMenuCtrl();
            LoginCtrl loginCtrl = new LoginCtrl();
    }
}