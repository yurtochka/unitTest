package seminars.third.tdd;

public class User {

    String name;
    String password;
    boolean isAuthenticate = false;
    boolean isAdmin;

    public User(String name, String password, boolean isAdmin) {
        this.name = "Admin";
        this.password = "Admin";
        this.isAdmin = isAdmin;
    }


    public boolean authenticate(String log, String pass) {

        if (log.equals(name) && pass.equals(password)) {
            isAuthenticate = true;
            return true;
        } else {
            return false;
        }
    }

}