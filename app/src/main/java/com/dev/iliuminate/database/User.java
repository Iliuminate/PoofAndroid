package com.dev.iliuminate.database;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Iliuminate on 04/07/2015.
 */
public class User extends SugarRecord<User> {

    String userName, name, lastName, passeord, gender;

    Date birthdate;

    public User() {
    }

    public User(String userName, String name, String lastName, String passeord, String gender, Date birthdate) {
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.passeord = passeord;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasseord() {
        return passeord;
    }
    public void setPasseord(String passeord) {
        this.passeord = passeord;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
