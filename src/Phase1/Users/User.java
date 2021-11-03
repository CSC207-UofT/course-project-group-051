package Phase1.Users;

import java.util.Date;

public abstract class User {
    /**
     * User is the base class for the different representations of our Users
     *
     * @param id is the id associated with user
     * @param fName is the first name of the user
     * @param lName is the last name of the user
     * @param birthdate is the birth-date of the user
     * @param password is a user-set password
     */
    private int id;
    private String fName;
    private String lName;
    private Date birthdate;
    private String password;

    public User(int id, String fName, String lName, Date birthdate, String password)
    {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.birthdate = birthdate;
        this.password = password;
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

    public Date getBirthdate(){return this.birthdate;}

    public String getPassword(){return this.password;}
}
