package com.proiect.echipa478a.proiectandroid.custom.datapojo;

import com.proiect.echipa478a.proiectandroid.custom.persistency.custom.UserDatabaseManager;
import com.proiect.echipa478a.proiectandroid.ui.LoginActivity;

/**
 * Created by Marius on 12/16/2016.
 */

public class User {
    private long userID;
    private String name;
    private String email;
    private static User userLogged = null;
    private static boolean guestUser = false;

    public User(String name, String email) {
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void setUserLogged(User user, UserDatabaseManager userDatabaseManager, String actionType) {
        if(userLogged != null && user != null) {
            user.setUserID(userLogged.getUserID());
        }
        userLogged = user;
        syncUser(userDatabaseManager, actionType);
    }

    public static User getUserLogged() {
        return userLogged;
    }

    public static boolean isGuestUser() {
        return guestUser;
    }

    public static void isGuestUser(boolean isGuest) {
        guestUser = isGuest;
    }

    private static void syncUser(UserDatabaseManager userDatabaseManager, String actionType) {
        if(actionType.equals(LoginActivity.REGISTER_OTHER_USER)) {
            userDatabaseManager.updateRecordByID(userLogged);
        } else if(actionType.equals(LoginActivity.NO_USER_LOGGED)) {
            long id = userDatabaseManager.insertRecord(userLogged);
            userLogged.setUserID(id);
        } else if(actionType.equals(LoginActivity.SIGN_IN_AS_GUEST)) {

        }
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long id) {
        this.userID = id;
    }
}
