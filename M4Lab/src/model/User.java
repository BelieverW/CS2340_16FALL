package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Daniel_RICE on 9/18/16.
 */
public class User {
    private final StringProperty userName = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final ObjectProperty<UserLevel> level = new SimpleObjectProperty<>();

    /* **********************
     * Getters and setters for properties
     */
    public String getUserName() { return userName.get(); }
    public void setUserName(String name) { userName.set(name); }

    public String getPassword() {return password.get(); }
    public void setPassword(String pw) { password.set(pw); }

    public UserLevel getUserLevel() { return level.get(); }
    public void setUserLevel(UserLevel _level) {  level.set(_level); }

    /**
     * Make a new user
     * @param name      the user's name
     * @param pw     the user's password
     * @param l        the user's userlevel
     */
    public User(String name, String pw, UserLevel l) {
        userName.set(name);
        password.set(pw);
        level.set(l);
    }

    /**
     * Make a new user
     * @param name      the user's name
     * @param pw     the user's password
     */
    public User(String name, String pw) {
        userName.set(name);
        password.set(pw);
        level.set(UserLevel.USER);
    }

    public boolean equals(User o) {
        return getUserName().equals(o.getUserName()) && getPassword().equals(o.getPassword());
    }

    public String toString() {
        return userName.get() + " " + password.get() + " " + level.get();
    }

}
