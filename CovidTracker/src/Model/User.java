/*
Project: COVID-19 Tracker Application
Course: IST 361
Author: Freiwald
Date Developed: 2/11/2022
Last Date Changed: 4/24/22
Revision: 2
 */
package Model;

import java.io.Serializable;

//class used to create user accounts for application
public class User implements Serializable {

    private String username, password;

    //constructor taking in strings
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //empty constructor
    public User() {
        username = "username";
        password = "password";
    }

    //getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //toString method for printing
    @Override
    public String toString() {
        return "Username: " + getUsername() + "\nPassword: " + getPassword();
    }

}
