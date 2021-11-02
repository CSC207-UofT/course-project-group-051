package Phase1.Users;

public abstract class User {

    /**
     * User is the base class for the different representations of our Users
     *
     * @param id is the id associated with user
     * @param fName is the first name of the user
     * @param lName is the last name of the user
     */
    private int id;
    private String fName;
    private String lName;

    public User(int id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    public int getId() {
        return this.id;
    }

    public String getfName() { return this.fName; }

    public String getlName() {
        return this.lName;
    }
}
