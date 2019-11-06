package org.launchcode.cheesemvc.models.user;

import java.util.ArrayList;

public class UserData {

    static ArrayList<User> users = new ArrayList<>();

    // getAll
    public static ArrayList<User> getAll() {
        return users;
    }

    // add
    public static void add(User newUser) {
        users.add(newUser);
    }

    // remove
    public static void remove(int id) {
        User userToRemove = getById(id);
        users.remove(userToRemove);
    }

    // update
    public static void update(User newUser) {
        User userToEdit = getById(newUser.getUserId());
        userToEdit.setUsername(newUser.getUsername());
        userToEdit.setEmail(newUser.getEmail());
        userToEdit.setPassword(newUser.getPassword());
    }

    // getById
    public static User getById(int id) {
        User theUser = null;
        for (User candidateUser : users) {
            if (candidateUser.getUserId() == id)  {
                theUser = candidateUser;
                break;
            }
        }
        return theUser;
    }
}
