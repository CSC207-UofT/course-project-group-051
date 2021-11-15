package Phase1.Users;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User is the base class for the different representations of our Users
 */
public abstract class User {

    int id;
    String fName;
    String lName;
    Date birthdate;
    String password;
    String bio;
    int age;

    /**
     * Creates a User object
     * @param id the user's ID
     * @param fName the user's first name
     * @param lName the user's last name
     * @param birthdate the user's birthdate
     * @param password the password
     */
    public User(int id, String fName, String lName, Date birthdate, String password)
    {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.birthdate = birthdate;
        this.password = password;
    }

    /**
     * @return the ID of this user
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return the first name of this user
     */
    public String getfName() {
        return this.fName;
    }

    /**
     * @return the last name of this user
     */
    public String getlName() {
        return this.lName;
    }

    /**
     * @return the birthday of this user
     */
    public Date getBirthdate(){return this.birthdate;}

    /**
     * @return the password
     */
    public String getPassword(){return this.password;}

    /**
     * @return the age of the user
     */
    public int getAge() {
        Date today = new Date();
        long diff = today.getTime() - this.getBirthdate().getTime();
        int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        return days / 365;
    }
}
