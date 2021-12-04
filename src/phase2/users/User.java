package phase2.users;

/**
 * Represents a User in our system and holds their information.
 */
public class User {

    private int id;
    private String fName;
    private String lName;

    /**
     * @param id the id representing this User in the database.
     */
    public User(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
