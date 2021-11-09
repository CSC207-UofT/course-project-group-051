package Phase1.Users;

import java.util.Date;

/**
 * User is the base class for the different representations of our Users
 */
public abstract class User {

    private int id;
    private String fName;
    private String lName;
    private Date birthdate;

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

    public Date getBirthdate(){return this.birthdate;}


    public void setfName(String fName) {this.fName = fName;}

    public void setLName(String lName) { this.lName = lName; }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }


}
