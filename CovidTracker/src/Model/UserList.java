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
import java.util.ArrayList;

//class used to create a file containing a list of users for the application
public class UserList {

    private ArrayList<User> listOfUsers = new ArrayList<>();
    private String userListFileName = "usersFile.ser";

    //constructor attempts to read user list and creates default list if file is empty, then prints to console
    public UserList() {

        readUserListFile();
        if (listOfUsers.isEmpty()) {
            createTestUserList();
            writeUserListFile();
            readUserListFile();
        }
        printUsersList();

    }

    //reads user list file and informs console if empty or not found
    public void readUserListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(userListFileName);
            in = new ObjectInputStream(fis);
            listOfUsers = (ArrayList) in.readObject();
            in.close();
            if (!listOfUsers.isEmpty()) {
                System.out.println("There are no Users in the file");
            }
        } catch (FileNotFoundException fne) {
            System.out.println("File was not found");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    //writes user list file with current model list of users
    public void writeUserListFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(userListFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfUsers);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //creates a default list of users
    public void createTestUserList() {
        User u1 = new User("default1", "123");
        User u2 = new User("default2", "321");
        User u3 = new User("default3", "456");
        User u4 = new User("default4", "654");

        listOfUsers.add(u1);
        listOfUsers.add(u2);
        listOfUsers.add(u3);
        listOfUsers.add(u4);
    }

    //method to check if username and password match for login authentication
    public boolean authenticate(User user) {

        for (User u : listOfUsers) {
            if (user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword())) {
                return true;
            }
        }
        return false;
    }

    //toString method for printing current contents of user list
    public void printUsersList() {
        System.out.println("These are the Users in the Current User List");
        for (User listOfUser : listOfUsers) {
            System.out.println(listOfUser.getUsername());
        }
    }

    //getters and setters
    public ArrayList<User> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(ArrayList<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public String getUserListFileName() {
        return userListFileName;
    }

    public void setUserListFileName(String userListFileName) {
        this.userListFileName = userListFileName;
    }
}
