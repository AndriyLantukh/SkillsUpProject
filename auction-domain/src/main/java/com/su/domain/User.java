package com.su.domain;

/**
 * Created by Инна on 17.09.2016.
 */
public class User {

    private String login;
    private String firstName;
    private String lastName;

    public User(String login, String firstName, String lastName){
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
