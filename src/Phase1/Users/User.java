package Phase1.Users;

import java.util.Date;
/**
 * Is the base class for the different representations of our Users that will be needed.
 */
public abstract class User {

    int id;
    String fName;
    String lName;
    Date birthdate;
    String password;

    public User(int id, String fName, String lName, Date birthdate, String password)
    {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.birthdate = birthdate;
        this.password = password;
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

    public Date getBirthdate(){return this.birthdate;}

    public String getPassword(){return this.password;}
}
