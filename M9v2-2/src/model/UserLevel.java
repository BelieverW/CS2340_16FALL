package model;

/**
 * Created by Daniel_RICE on 9/18/16.
 * M5_V2
 */
public enum UserLevel {
    USER("User"), WORKER("Worker"), MANAGER("Manager"), ADMIN("Admin");

    private final String role;

    UserLevel(String role) {
        this.role = role;
    }
/*
    public String getUserLevel() {
        return role;
    }
*/
    public String toString() {
        return role;
    }
}
