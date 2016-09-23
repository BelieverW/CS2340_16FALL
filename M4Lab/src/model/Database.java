package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel_RICE on 9/18/16.
 */
public class Database {

    private List<User> users;

    public Database() throws IOException {
        users = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("./src/id.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] split = line.split(" ");
            users.add(new User(split[0], split[1], UserLevel.valueOf(split[2].toUpperCase())));
        }
    }


    /**
     * return a boolean to show if the input user is in the database
     * @param name the input name
     * @param password the input password
     * @return boolean
     * */
    public User getAuth(String name, String password) {
        User newUser = new User(name, password, UserLevel.USER);
        System.out.println(newUser);
        for (User u : users) {
            if (u.equals(newUser)) {
                return u;
            }
            System.out.println(u);
        }
        return null;
    }
    public boolean checkExistance(String username) {
        for (User u : users) {
            if (u.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param name
     * @param password
     * @param level
     */
    public void registerUser(String name, String password, UserLevel level) {
        User newuser = new User(name, password, level);
        //implementation
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("./src/id.txt", true));
            out.newLine();
            out.write(name + " " + password + " " + level.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        Database db = new Database();

        System.out.println(db.users.get(5).getUserLevel());
        System.out.println(db.users.get(5).getPassword());
        System.out.println(db.users.get(5).getUserName());

    }
}
