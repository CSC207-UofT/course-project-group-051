package Phase1.Users;


/**
 * Is the base class for the different representations of our Users that will be needed.
 */
public abstract class User {

    int id;
    String fName;
    String lName;

    public User(int id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }
}
