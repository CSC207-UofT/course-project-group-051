package Phase1.Users;

/**
 * User is the base class for the different representations of our Users
 */
public abstract class User {

    private int id;
    private String fName;
    private String lName;


    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getfName() {
        return this.fName;
    }

    public String getlName() {
        return this.lName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}

